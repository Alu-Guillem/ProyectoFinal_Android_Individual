package com.trycatchers.hotel.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.trycatchers.hotel.compose.components.navigation.BottomBar
import com.trycatchers.hotel.compose.components.navigation.TopBar
import com.trycatchers.hotel.compose.screens.LoginScreen
import com.trycatchers.hotel.compose.screens.RegisterScreen
import com.trycatchers.hotel.compose.screens.RoomCatalogScreen
import com.trycatchers.hotel.compose.screens.RoomDetailsScreen
import com.trycatchers.hotel.compose.screens.RoomFinderScreen
import com.trycatchers.hotel.compose.screens.UserProfileScreen

/**
 * Composable raíz de la aplicación.
 *
 * Configura el scaffold principal con TopBar y BottomBar condicionales, y delega la navegación a
 * [HotelPereMariaNavHost].
 */
@Composable
fun HotelPereMariaApp(onThemeToggle: () -> Unit) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute: String = navBackStackEntry?.destination?.route ?: ""

    val currentScreen = Screen.fromRoute(currentRoute)
    val showTopBar = currentScreen?.showTopBar ?: true
    val showBottomBar = currentScreen?.showBottomBar ?: true

    fun navigateTo(screen: Screen, route: String? = null, popToRoot: Boolean = false) {
        val destination = route ?: screen.route
        navController.navigate(destination) {
            if (popToRoot) {
                popUpTo(Screen.InitialSearch.route) { inclusive = false }
            }
            launchSingleTop = true
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (showTopBar) {
                TopBar(
                    navigateTo = { screen, route ->
                        navigateTo(screen, route, popToRoot = false)
                    },
                    onThemeToggle = onThemeToggle
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomBar(
                    navigateTo = { screen -> navigateTo(screen, popToRoot = true) },
                    currentRoute = currentRoute
                )
            }
        }
    ) { innerPadding ->
        HotelPereMariaNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            navigateTo = ::navigateTo
        )
    }
}
@Composable
fun HotelPereMariaNavHost(
    navController: NavHostController,
    modifier: Modifier,
    navigateTo: (String) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {

        composable(route = Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.RoomFinder.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onRegisterClick = { navigateTo(Screen.Register.route) }

            )
        }

        composable(route = Screen.Register.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Screen.RoomFinder.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(route = Screen.RoomFinder.route) {
            RoomFinderScreen(navigateToCreateBooking = { roomId ->
                navigateTo(
                    Screen.RoomDetails.createRoute(roomId)
                )
            })
        }

        composable(route = Screen.RoomCatalog.route) {
            RoomCatalogScreen(navigateToRoomDetails = { roomId ->
                navigateTo(
                    Screen.RoomDetails.createRoute(roomId)
                )

            })
        }



        composable(route = Screen.UserProfile.route) {
            UserProfileScreen(
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(route = Screen.RoomDetails.route){
            RoomDetailsScreen()
        }
    }
}

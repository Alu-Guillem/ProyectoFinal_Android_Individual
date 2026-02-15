package com.trycatchers.hotel.compose

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList(),
) {
    data object RoomFinder : Screen("room-finder")
    data object RoomCatalog : Screen("room-catalog")
    data object UserAccount : Screen("user-account")
    data object RoomDetails :
        Screen(
            "room-details/{roomId}",
            listOf(navArgument(name = "roomId") { type = NavType.StringType })
        ) {
        fun createRoute(roomId: String) = "room-details/$roomId"
    }

    data object CreateBooking :
        Screen(
            "create-booking/{roomId}?start-date={startDate}&end-date={endDate}&occupants={occupants}",
            listOf(
                navArgument(name = "roomId") { type = NavType.StringType },
                navArgument(name = "startDate") { type = NavType.StringType },
                navArgument(name = "endDate") { type = NavType.StringType },
                navArgument(name = "occupants") { type = NavType.IntType }
            )
        ) {
        fun createRoute(roomId: String) = "room-details/$roomId"
    }
}

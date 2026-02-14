package com.trycatchers.hotel.compose

import androidx.navigation.NamedNavArgument

sealed class Screen (
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList(),
){
    data object RoomFinder : Screen("room-finder")
    data object RoomCatalog : Screen("room-catalog")
    data object UserAccount : Screen("user-account")
}
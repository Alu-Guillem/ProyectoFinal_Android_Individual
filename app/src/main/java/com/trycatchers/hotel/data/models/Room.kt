package com.trycatchers.hotel.data.models

data class Room(
    val roomId: String? = null,
    val number: Int,
    val price: Double,
    val type: String
)
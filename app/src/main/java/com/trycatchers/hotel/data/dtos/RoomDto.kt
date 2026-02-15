package com.trycatchers.hotel.data.dtos

import com.squareup.moshi.Json
import com.trycatchers.hotel.data.models.Room

data class RoomDto(
        @Json(name = "roomId") val roomId: String?,
        @Json(name = "number") val number: Int,
        @Json(name = "price") val price: Double,
        @Json(name = "type") val type: String
) {
    fun toDomain() = Room(roomId = roomId, number = number, price = price, type = type)
}

fun List<RoomDto>.toDomain() = map { it.toDomain() }

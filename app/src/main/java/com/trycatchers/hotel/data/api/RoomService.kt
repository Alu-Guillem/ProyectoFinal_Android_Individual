package com.trycatchers.hotel.data.api

import com.trycatchers.hotel.data.dtos.RoomDto
import com.trycatchers.hotel.data.dtos.RoomStatsDto
import retrofit2.http.*

interface RoomService {

    @GET("rooms?maintenace=false&closed=false&occuped=false")
    suspend fun getAllRooms(): List<RoomDto>

    @GET("rooms?maintenace=false&closed=false&occuped=false")
    suspend fun searchAvailableRooms(@QueryMap filters: Map<String, String>): List<RoomDto>

    @GET("rooms/{id}")
    suspend fun getRoomById(@Path("id") id: String): RoomDto

    @GET("rooms/stats")
    suspend fun getRoomStats(): List<RoomStatsDto>

    @POST("rooms")
    suspend fun createRoom(@Body room: RoomDto): RoomDto

    @PATCH("rooms/{id}")
    suspend fun updateRoom(@Path("id") id: String, @Body room: RoomDto): RoomDto

    @DELETE("rooms/{id}")
    suspend fun deleteRoom(@Path("id") id: String)
}

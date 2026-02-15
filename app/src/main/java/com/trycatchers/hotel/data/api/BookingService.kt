package com.trycatchers.hotel.data.api

import com.trycatchers.hotel.data.dtos.BookingDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

/** Servicio de API para gestionar reservas mediante Retrofit */
interface BookingService {

    @GET("bookings") suspend fun getAllBookings(): List<BookingDto>

    @GET("bookings/{id}") suspend fun getBookingById(@Path("id") id: String): BookingDto

    @POST("bookings") suspend fun createBooking(@Body booking: BookingDto): BookingDto

    @PATCH("bookings/{id}")
    suspend fun updateBooking(@Path("id") id: String, @Body booking: BookingDto): BookingDto

    @DELETE("bookings/{id}") suspend fun deleteBooking(@Path("id") id: String)
}

package com.trycatchers.hotel.data.repositories

import com.trycatchers.hotel.data.api.BookingService
import com.trycatchers.hotel.data.dtos.BookingDto
import com.trycatchers.hotel.data.dtos.toDomain
import com.trycatchers.hotel.data.models.Booking
import javax.inject.Inject

/**
 * Repositorio para gestionar operaciones de reservas Convierte DTOs de la API a modelos de dominio
 */
class BookingRepository @Inject constructor(private val bookingService: BookingService) {

    /**
     * Obtiene todas las reservas de la API
     * @return Lista de todas las reservas
     */
    suspend fun getAll(): List<Booking> {
        return bookingService.getAllBookings().toDomain()
    }

    /**
     * Obtiene una reserva por su ID
     * @param id ID de la reserva
     * @return Datos de la reserva
     */
    suspend fun getById(id: String): Booking {
        return bookingService.getBookingById(id).toDomain()
    }

    /**
     * Crea una nueva reserva
     * @param booking Datos de la reserva a crear
     * @return Reserva creada con su ID asignado
     */
    suspend fun create(booking: Booking): Booking {
        val dto = booking.toDto()
        return bookingService.createBooking(dto).toDomain()
    }

    /**
     * Actualiza una reserva existente
     * @param id ID de la reserva a actualizar
     * @param booking Datos actualizados de la reserva
     * @return Reserva actualizada
     */
    suspend fun update(id: String, booking: Booking): Booking {
        val dto = booking.toDto()
        return bookingService.updateBooking(id, dto).toDomain()
    }

    /**
     * Elimina una reserva
     * @param id ID de la reserva a eliminar
     */
    suspend fun delete(id: String) {
        bookingService.deleteBooking(id)
    }
}

/** Extensión para convertir modelo de dominio a DTO */
fun Booking.toDto() =
        BookingDto(
                bookingId = bookingId,
                userId = userId,
                roomId = roomId,
                startDate = startDate,
                endDate = endDate,
                bookingDate = bookingDate,
                occupants = occupants,
                pricePerNight = pricePerNight,
                totalPrice = totalPrice,
                discount = discount,
                totalNights = totalNights,
                status = status,
                isPaid = isPaid,
                checkInNotified = checkInNotified,
                checkOutNotified = checkOutNotified
        )

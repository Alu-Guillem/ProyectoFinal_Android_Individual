package com.trycatchers.hotel.viewmodels

import androidx.lifecycle.ViewModel
import com.trycatchers.hotel.data.repositories.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomFinderViewModel @Inject constructor(private val sessionRepository: SessionRepository) :
        ViewModel() {
    init {
        sessionRepository.saveSession(
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2OTc3ODM3YjBiZTMyOTdlZmFiNTM1MTAiLCJyb2xlIjoiY3VzdG9tZXIiLCJpYXQiOjE3NzA3NTExMzgsImV4cCI6MTc3MjA0NzEzOH0.GgSiRq-INeSMzUMxqH7nTC8AUZe1czAqan5keN2qXZo"
        )
    }
}

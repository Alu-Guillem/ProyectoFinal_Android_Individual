package com.trycatchers.hotel.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val roomId: String = savedStateHandle["roomId"] ?: ""
}

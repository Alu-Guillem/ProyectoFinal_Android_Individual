package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.trycatchers.hotel.viewmodels.RoomFinderViewModel

@Composable
fun RoomFinderScreen(navigateToCreateBooking: (String) -> Unit) {
    val roomFinderViewModel: RoomFinderViewModel = hiltViewModel()
    RoomFinderView()
}

@Composable
fun RoomFinderView() {
    Text(text = "RoomFinderView Works!")
}

@Preview(showSystemUi = true)
@Composable
fun RoomFinderPreview() {
    Box(modifier = Modifier.fillMaxSize()) { RoomFinderView() }
}

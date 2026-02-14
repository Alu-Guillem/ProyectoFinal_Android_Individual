package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trycatchers.hotel.viewmodels.RoomDetailsViewModel

@Composable
fun RoomDetailsScreen() {
    val roomDetailsViewModel: RoomDetailsViewModel = viewModel()

    RoomDetailsView()
}

@Composable
fun RoomDetailsView() {

}

@Preview(showSystemUi = true)
@Composable
fun RoomDetailsPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        RoomDetailsView()
    }
}
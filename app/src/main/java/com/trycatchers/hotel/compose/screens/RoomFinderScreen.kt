package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trycatchers.hotel.viewmodels.RoomFinderViewModel

@Composable
fun RoomFinderScreen() {
    val roomFinderViewModel: RoomFinderViewModel = viewModel()

    RoomFinderView()
}

@Composable
fun RoomFinderView() {

}

@Preview(showSystemUi = true)
@Composable
fun RoomFinderPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        RoomFinderView()
    }
}
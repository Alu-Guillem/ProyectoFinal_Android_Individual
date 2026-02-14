package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trycatchers.hotel.viewmodels.NewBookingViewModel

@Composable
fun NewBookingScreen() {
    val roomCatalogViewModel: NewBookingViewModel = viewModel()

    NewBookingView()
}

@Composable
fun NewBookingView() {

}

@Preview(showSystemUi = true)
@Composable
fun NewBookingPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        NewBookingView()
    }
}




package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.trycatchers.hotel.viewmodels.NewBookingViewModel

@Composable
fun NewBookingScreen() {
    val roomCatalogViewModel: NewBookingViewModel = hiltViewModel()

    NewBookingView()
}

@Composable
fun NewBookingView() {
    Text(text = "NewBookingView Works!")
}

@Preview(showSystemUi = true)
@Composable
fun NewBookingPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        NewBookingView()
    }
}




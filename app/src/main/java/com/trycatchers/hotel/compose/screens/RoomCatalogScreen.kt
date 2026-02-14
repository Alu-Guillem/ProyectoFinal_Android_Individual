package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trycatchers.hotel.viewmodels.RoomCatalogViewModel

@Composable
fun RoomCatalogScreen() {
    val roomCatalogViewModel: RoomCatalogViewModel = viewModel()

    RoomCatalogView()
}

@Composable
fun RoomCatalogView() {

}

@Preview(showSystemUi = true)
@Composable
fun RoomCatalogPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        RoomCatalogView()
    }
}




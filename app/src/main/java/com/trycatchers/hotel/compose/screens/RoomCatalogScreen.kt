package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.trycatchers.hotel.viewmodels.RoomCatalogViewModel

@Composable
fun RoomCatalogScreen(navigateToRoomDetails: (String) -> Unit) {
    val roomCatalogViewModel: RoomCatalogViewModel = hiltViewModel()

    RoomCatalogView(navigateToRoomDetails = navigateToRoomDetails)
}

@Composable
fun RoomCatalogView(navigateToRoomDetails: (String) -> Unit) {
    Column {
        Text(text = "RoomCatalogView Works!")

        Button(onClick = { navigateToRoomDetails("roomId123") }) {
            Text(text = "Go to Room Details")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun RoomCatalogPreview() {
    Box(modifier = Modifier.fillMaxSize()) { RoomCatalogView({}) }
}

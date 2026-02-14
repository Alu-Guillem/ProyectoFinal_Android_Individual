package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trycatchers.hotel.viewmodels.UserAccountViewModel

@Composable
fun UserAccountScreen() {
    val userAccountViewModel: UserAccountViewModel = viewModel()

    UserAccountView()
}

@Composable
fun UserAccountView() {

}

@Preview(showSystemUi = true)
@Composable
fun UserAccountPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        UserAccountView()
    }
}
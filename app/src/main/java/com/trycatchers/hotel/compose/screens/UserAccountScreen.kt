package com.trycatchers.hotel.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.trycatchers.hotel.viewmodels.UserAccountViewModel

@Composable
fun UserAccountScreen() {
    val userAccountViewModel: UserAccountViewModel = hiltViewModel()

    UserAccountView()
}

@Composable
fun UserAccountView() {
    Text(text = "UserAccountView Works!")
}

@Preview(showSystemUi = true)
@Composable
fun UserAccountPreview() {
    Box(modifier = Modifier.fillMaxSize()) { UserAccountView() }
}

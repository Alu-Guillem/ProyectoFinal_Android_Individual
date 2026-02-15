package com.trycatchers.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.trycatchers.hotel.compose.HotelPereMariaApp
import com.trycatchers.hotel.ui.theme.HotelPereMariaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by rememberSaveable { mutableStateOf(true) }
            HotelPereMariaTheme(darkTheme = darkTheme) {
                HotelPereMariaApp(onThemeToggle = { darkTheme = !darkTheme })
            }
        }
    }
}

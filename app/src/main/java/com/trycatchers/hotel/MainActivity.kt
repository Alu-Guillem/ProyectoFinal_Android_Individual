package com.trycatchers.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.trycatchers.hotel.compose.HotelPereMariaApp
import com.trycatchers.hotel.ui.theme.HotelPereMariaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HotelPereMariaTheme {
                HotelPereMariaApp()
            }
        }
    }
}
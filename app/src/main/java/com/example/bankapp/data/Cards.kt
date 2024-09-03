package com.example.bankapp.data

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter


data class Cards(
    val cardName:String,
    val description: String,
    val image: Painter
)

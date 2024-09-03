package com.example.bankapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.bankapp.ui.theme.BankAppTheme
import com.example.bankapp.ui.theme.Blue1
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankAppTheme {
                // Combine both actions into one function
                SetSystemBarsColor(color = Color(0xFF00468B))
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetResult()
                }
            }
        }
    }
}

// Function to set both status bar and navigation bar colors
@Composable
private fun SetSystemBarsColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = false // Change to true if you want light icons
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GetResult() {
    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(color = Blue1)
        ) {
            items(listOf("TopAppBar", "BalanceSection", "CardSection", "NewInformation", "EditHome")) { item ->
                when (item) {
                    "TopAppBar" -> TopAppBar()
                    "BalanceSection" -> BalanceSection()
                    "CardSection" -> CardSection()
                    "NewInformation" -> NewInformation()
                    "EditHome" -> EditHome()
                }
            }
        }
    }
}



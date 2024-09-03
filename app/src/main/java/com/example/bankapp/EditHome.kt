package com.example.bankapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditThemes() {
    // State to track the currently selected setting
    var selectedSetting by remember { mutableStateOf<String?>(null) }

    // List of settings
    val settings = listOf(
        "Themes", "Dark Mode", "Language"
    )

    // List of theme images
    val themeList = listOf(
        painterResource(R.drawable.screen),
        painterResource(R.drawable.screen),
        painterResource(R.drawable.screen),
        painterResource(R.drawable.screen)
    )

    // Define colors
    val LightBlue = Color(0xFFCBE5FF)
    val LightGray = Color(0xFFA0A0A0)

    // Display AssistChips for each setting
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        settings.forEach { setting ->
            AssistChip(
                onClick = { selectedSetting = setting }, // Set selected setting on click
                label = { Text(text = setting) },
                modifier = Modifier.padding(horizontal = 8.dp),
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (selectedSetting == setting) LightBlue else Color.LightGray, // Conditional color
                    labelColor = if(selectedSetting == setting) Color.Black else Color.Gray
                ),
                border = BorderStroke(0.dp,Color.White)
            )
        }
    }

    // Conditional content based on selected setting
    when (selectedSetting) {
        "Themes" -> {
            LazyRow( // Use LazyRow for horizontal scrolling
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(themeList) { painter ->
                    Image(
                        painter = painter,
                        contentDescription = "Theme Image",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
        "Dark Mode" -> {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Dark Mode Settings")
            }
        }
        "Language" -> {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Language Settings")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditHome() {
    // State to manage the bottom sheet
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    // State to check if the bottom sheet is open
    var isSheetOpen by remember {
        mutableStateOf(false)
    }

    // Box layout to center the button
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { isSheetOpen = true }, // Open the bottom sheet on click
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.padding(bottom = 46.dp) // Bottom padding to move the button up
        ) {
            Text(text = "Edit Home", color = Color.Black)
        }
    }

    // Conditional display of ModalBottomSheet
    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { isSheetOpen = false }, // Close on dismiss
            sheetState = sheetState, // Provide the sheet state
            containerColor = Color.White, // Background color for the bottom sheet
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp) // Rounded corners for the bottom sheet
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 2.dp)
            ) {
                Text(
                    "Appearance",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp) // Padding below the title
                )
                EditThemes() // Call to EditThemes composable to display AssistChip and images
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditHomePreview() {
    EditHome()
}

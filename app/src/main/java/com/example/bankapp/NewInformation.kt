package com.example.bankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun NewInformation() {
    val itemSlider = listOf(
        painterResource(id = R.drawable.slider1),
        painterResource(id = R.drawable.slider2),
        painterResource(id = R.drawable.slider3)
        // Add more images as needed
    )

    // Create a LazyListState to control the scroll position
    val listState = rememberLazyListState()

    // LaunchedEffect to automatically scroll the LazyRow
    LaunchedEffect(Unit) {
        while (true) {
            // Scroll by one item at a time
            listState.animateScrollToItem(
                index = (listState.firstVisibleItemIndex + 1) % itemSlider.size
            )
            // Adjust the delay to control the scroll speed
            delay(3000) // 3 seconds delay
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), // Adjust height as needed
        contentPadding = PaddingValues(horizontal = 8.dp), // Add horizontal padding
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items
    ) {
        items(itemSlider) { image ->
            Row(
                modifier = Modifier
                    .width(380.dp) // Fixed width to ensure all images are displayed properly
                    .height(200.dp) // Fixed height to match LazyRow height
                    .padding(6.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewInformationPreview() {
    NewInformation()
}

package com.example.bankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.Cards

@Composable
fun CardSection() {
    val cardItems = listOf(
        Cards(
            cardName = "Account",
            description = "Your Balance",
            image = painterResource(id = R.drawable.ic_acc)
        ),
        Cards(
            cardName = "Pay bills",
            description = "School, Shop, etc",
            image = painterResource(id = R.drawable.ic_bills)
        ),
        Cards(
            cardName = "Transfer",
            description = "Send money",
            image = painterResource(id = R.drawable.ic_transfer)
        ),
        Cards(
            cardName = "Favorites",
            description = "Users",
            image = painterResource(id = R.drawable.ic_fav)
        ),
        Cards(
            cardName = "BAB Scan",
            description = "School, Shop, etc",
            image = painterResource(id = R.drawable.ic_scan)
        ),
        Cards(
            cardName = "Service",
            description = "Your Balance",
            image = painterResource(id = R.drawable.ic_service)
        )
    )

    val Blue1 = Color(0xFF4DEAE) // Darker blue color
    val GradientEndColor = Color(0xFF205C9A) // Lighter blue color

    // Define the gradient for the container background
    val backgroundGradient = Brush.linearGradient(
        colors = listOf(
            Blue1,
            GradientEndColor
        )
    )

    // Define the gradient border colors
    val gradientBorderBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFF2D7C), // FF2D7C: 0%
            Color(0xFFD027B5), // D027B5: 44%
            Color(0xFFB623D5), // B623D5: 64%
            Color(0xFF941FFF)  // 941FFF: 100%
        )
    )

    // Outer box with gradient background and border
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp) // Height set to fit all items without scrolling
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val pathEffect = PathEffect.cornerPathEffect(16.dp.toPx()) // Rounded corner effect
                drawRoundRect(
                    brush = gradientBorderBrush,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokeWidth, pathEffect = pathEffect)
                )
            }
            .clip(RoundedCornerShape(16.dp)) // Rounded corners for the gradient box
            .background(brush = backgroundGradient) // Gradient background for the card container
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2), // Two rows for the grid
            modifier = Modifier
                .fillMaxSize() // Fill the available space
            , // Padding inside the gradient box
            contentPadding = PaddingValues(6.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp), // Spacing between columns
            verticalArrangement = Arrangement.spacedBy(2.dp) // Spacing between rows
        ) {
            items(cardItems) { card ->
                CardItem(card)
            }
        }
    }
}

@Composable
fun CardItem(card: Cards) {
    // Smaller individual card with white background
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White), // White background for the card
        elevation = CardDefaults.elevatedCardElevation(4.dp), // Elevation for shadow effect
        modifier = Modifier
            .padding(2.dp)
            .width(116.dp) // Adjust card width to fit within the grid
            .height(30.dp) // Adjust card height to fit within the grid
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            // Image at the top right
            Image(
                painter = card.image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopEnd)

            )
            // Column for text at the bottom left
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = card.cardName,
                    fontSize = 14.sp, // Adjust font size
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = card.description,
                    fontSize = 8.sp, // Adjust font size
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun PrevieSection(){
    CardSection()
}


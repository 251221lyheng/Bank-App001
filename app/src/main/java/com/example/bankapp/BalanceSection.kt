package com.example.bankapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BalanceSection() {
    // State to manage blur effect
    var isBlurred by remember { mutableStateOf(true) }

    // Define the colors for the gradient
    val Blue1 = Color(0xFF4DEAE) // Darker blue color
    val GradientEndColor = Color(0xFF205C9A) // Lighter blue color

    // Gradient for the card background
    val backgroundGradient = Brush.linearGradient(
        colors = listOf(
            Blue1,
            GradientEndColor
        )
    )

    // Gradient border colors
    val gradientBorderBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFF2D7C), // FF2D7C: 0%
            Color(0xFFD027B5), // D027B5: 44%
            Color(0xFFB623D5), // B623D5: 64%
            Color(0xFF941FFF)  // 941FFF: 100%
        )
    )

    // Card with gradient background and border
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .height(160.dp)
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val pathEffect = PathEffect.cornerPathEffect(16.dp.toPx()) // Rounded corner effect
                drawRoundRect(
                    brush = gradientBorderBrush,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokeWidth, pathEffect = pathEffect)
                )
            }
            .clip(RoundedCornerShape(16.dp)) // Clip content to prevent overflow outside the rounded border
            .background(brush = backgroundGradient) // Gradient background for the card
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Section: Balance Display
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(vertical = 4.dp, horizontal = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .blur(radius = if(isBlurred) 100.dp else 0.dp),
                ) {
                    Text(
                        text = "$2567.456",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isBlurred) Color.Gray else Color.Black,
                        textAlign = TextAlign.Center,

                        )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = "eye view",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            // Toggle blur effect on click
                            isBlurred = !isBlurred
                        }
                )
            }

            // Spacer between top and middle sections
            Spacer(modifier = Modifier.height(2.dp))

            // Middle Section: Account Type Display
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF34C2FF))
                        .padding(vertical = 4.dp, horizontal = 12.dp),
                ) {
                    Text(
                        text = "Default",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Saving",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }

            // Spacer between middle and bottom sections
            Spacer(modifier = Modifier.height(24.dp))

            // Bottom Section: Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_receive),
                        contentDescription = "Receive Money",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Receive Money",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pay),
                        contentDescription = "Send Money",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Send Money",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BalanceSectionPreview() {
    BalanceSection()
}

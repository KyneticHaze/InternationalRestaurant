package com.example.internationalrestaurant.ui.screens.meal.meals.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.primary

@Composable
fun MealCard(
    meal: Meal,
    onMealClick : (String) -> Unit,
    starredMeal : (Meal) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(10.dp)
            .clickable { onMealClick(meal.mealId.orEmpty()) }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = meal.mealImg,
                contentDescription = meal.mealName,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
            IconButton(
                onClick = {
                    starredMeal(meal)
                }, modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(
                        primary, shape = RoundedCornerShape(10.dp)
                    )
                    .size(35.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Favorite Drink",
                    tint = background
                )
            }
            Text(
                text = meal.mealName.orEmpty(),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                fontStyle = FontStyle.Italic,
                color = background,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Gray
                            )
                        )
                    )
                    .padding(8.dp)
            )
        }
    }
}
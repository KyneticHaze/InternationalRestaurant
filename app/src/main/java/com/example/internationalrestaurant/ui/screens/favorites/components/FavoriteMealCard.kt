package com.example.internationalrestaurant.ui.screens.favorites.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.secondary

@Composable
fun FavoriteMealCard(
    meal: Meal,
    onDeleteMeal: (Meal) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = secondary.copy(.6f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().background(secondary)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = meal.mealImg,
                    contentDescription = meal.mealName,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = meal.mealName.orEmpty(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.W500,
                    maxLines = 2,
                    color = background.copy(.8f),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(160.dp)
                )
            }
            IconButton(onClick = {
                onDeleteMeal(meal)
            }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Meal", tint = background.copy(.8f))
            }
        }
    }
}
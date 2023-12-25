package com.example.internationalrestaurant.ui.screens.meal.meals.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.internationalrestaurant.data.remote.category.Category
import com.example.internationalrestaurant.ui.theme.tertiary

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Box(
        modifier = modifier
            .clickable {
                onClick(category.categoryName.orEmpty())
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            AsyncImage(
                model = category.categoryImg,
                contentDescription = category.categoryName,
                contentScale = ContentScale.Fit
            )
            Text(
                text = category.categoryName.orEmpty(),
                style = MaterialTheme.typography.headlineSmall,
                color = tertiary
            )
        }
    }
}
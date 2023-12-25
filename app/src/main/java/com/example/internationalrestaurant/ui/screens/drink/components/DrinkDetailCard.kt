package com.example.internationalrestaurant.ui.screens.drink.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.primary
import com.example.internationalrestaurant.ui.theme.tertiary

@Composable
fun DrinkDetailCard(
    drink: Drink
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = background
        ),
        modifier = Modifier
            .padding(15.dp)
            .border(
                width = 1.dp,
                color = primary,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = drink.drinkImage,
                contentDescription = drink.drinkName,
                contentScale = ContentScale.Crop,
                alignment = Alignment.CenterStart,
                modifier = Modifier.size(height = 220.dp, width = 150.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = drink.drinkName.orEmpty(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = primary,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = drink.drinkCategory.orEmpty(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = tertiary
                )
                Text(
                    text = drink.drinkDesc.orEmpty(),
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 6,
                    fontStyle = FontStyle.Italic,
                )
                Text(
                    text = drink.drinkAlcoholic.orEmpty(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = tertiary
                )
            }
        }
    }
}
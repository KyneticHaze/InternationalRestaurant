package com.example.internationalrestaurant.ui.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
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
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.ui.screens.favorites.components.FavoriteDrinkCard
import com.example.internationalrestaurant.ui.screens.favorites.components.FavoriteMealCard
import com.example.internationalrestaurant.ui.screens.favorites.viewmodel.FavoritesScreenViewModel
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.secondary

@Composable
fun FavoritesScreen(
    viewModel: FavoritesScreenViewModel = hiltViewModel()
) {

    val mealState = viewModel.mealState.value
    val drinkState = viewModel.drinkState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column {
            Text(
                text = "Meals",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp, top = 10.dp, bottom = 5.dp),
                style = MaterialTheme.typography.headlineLarge,
                color = secondary
            )
            mealState.meals.let { meals ->
                LazyColumn(
                    modifier = Modifier
                        .height(300.dp)
                ) {
                    items(meals) { meal ->
                        FavoriteMealCard(meal = meal) {
                            // Delete meal to room db
                            viewModel.deleteMeal(it)
                        }
                    }
                }
            }
            Text(
                text = "Drinks",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp, top = 5.dp, bottom = 5.dp),
                style = MaterialTheme.typography.headlineLarge,
                color = secondary
            )
            drinkState.drinks.let { drinks ->
                LazyColumn(
                    modifier = Modifier
                        .height(350.dp)
                ) {
                    items(drinks) { drink ->
                        FavoriteDrinkCard(drink = drink) {
                            // Delete drink to room db
                            viewModel.deleteDrink(it)
                        }
                    }
                }
            }
        }
    }
}


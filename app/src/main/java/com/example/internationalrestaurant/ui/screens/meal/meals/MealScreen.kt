package com.example.internationalrestaurant.ui.screens.meal.meals

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.internationalrestaurant.R
import com.example.internationalrestaurant.ui.screens.meal.meals.components.CategoryItem
import com.example.internationalrestaurant.common.SearchBar
import com.example.internationalrestaurant.common.TitleText
import com.example.internationalrestaurant.ui.screens.meal.meals.components.MealCard
import com.example.internationalrestaurant.ui.screens.meal.meals.viewmodel.MealViewModel
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.secondary
import com.example.internationalrestaurant.ui.theme.tertiary

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MealScreen(
    viewModel: MealViewModel = hiltViewModel(),
    onNavigateMealDetail: (String) -> Unit,
    onNavigateCategoryMeals: (String) -> Unit
) {
    val mealState = viewModel.mealState.value
    val categoryState = viewModel.categoryState.value
    val searchQuery = viewModel.searchQuery.value


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.logo_transparent),
                contentDescription = "International Restaurant",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            TitleText(text = "Categories", textColor = secondary)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categoryState.category) { category ->
                    CategoryItem(category = category, onClick = { onNavigateCategoryMeals(it) })
                }
            }
            TitleText(text = "Search Meal By First Letter", textColor = secondary)
            SearchBar(text = searchQuery,
                onTextChange = { viewModel.getMealsFirstLetter(it) },
                onClearClick = {
                    viewModel.clearMeal()
                },
                placeholder = "Search Meal"
            )
            mealState.meals.let { meals ->
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(meals) { meal ->
                        MealCard(meal = meal, onMealClick = {
                            onNavigateMealDetail(it)
                        }, starredMeal = {
                            // Start Meal to Room
                            viewModel.addMeal(it)
                        })
                    }
                }
            }
        }
    }
}
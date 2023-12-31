package com.example.internationalrestaurant.ui.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.internationalrestaurant.common.Params
import com.example.internationalrestaurant.common.Routes
import com.example.internationalrestaurant.ui.screens.drink.DrinkScreen
import com.example.internationalrestaurant.ui.screens.favorites.FavoritesScreen
import com.example.internationalrestaurant.ui.screens.meal.categoryDetail.CategoryMealsScreen
import com.example.internationalrestaurant.ui.screens.meal.mealDetail.MealDetailScreen
import com.example.internationalrestaurant.ui.screens.meal.meals.MealScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavGraphComponent(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Meal.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Routes.Meal.route) {
            MealScreen(
                onNavigateMealDetail = {
                    navHostController.navigate("${Routes.MealDetail.route}/$it")
                },
                onNavigateCategoryMeals = {
                    navHostController.navigate("${Routes.CategoryMeals.route}/$it")
                }
            )
        }
        composable("${Routes.MealDetail.route}/{${Params.PARAM_MEAL_ID}}") {
            MealDetailScreen()
        }
        composable("${Routes.CategoryMeals.route}/{${Params.PARAM_CATEGORY_MEALS_NAME}}") {
            CategoryMealsScreen()
        }
        composable(Routes.Drink.route) {
            DrinkScreen()
        }
        composable(Routes.Favorites.route) {
            FavoritesScreen()
        }
    }
}
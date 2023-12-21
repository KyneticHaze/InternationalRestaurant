package com.example.internationalrestaurant.ui.navigation

import androidx.compose.material.icons.Icons
import com.example.internationalrestaurant.R
import com.example.internationalrestaurant.common.Routes

sealed class NavItems(
    val title : String,
    val icon : Int,
    val route : String,
) {
    data object Meal : NavItems(
        title = "Meal",
        icon = R.drawable.meal,
        route = Routes.Meal.route
    )
    data object Drink : NavItems(
        title = "Drink",
        icon = R.drawable.drink,
        route = Routes.Drink.route
    )
    data object Favorites : NavItems(
        title = "Favorites",
        icon = R.drawable.star,
        route = Routes.Favorites.route
    )
}
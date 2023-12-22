package com.example.internationalrestaurant.common

sealed class Routes(val route : String) {
    data object Meal : Routes("meal_screen")
    data object MealDetail : Routes("meal_detail_screen")
    data object CategoryMeals : Routes("category_meals_screen")
    data object Drink : Routes("drink_screen")
    data object Favorites : Routes("favorites_screen")
}
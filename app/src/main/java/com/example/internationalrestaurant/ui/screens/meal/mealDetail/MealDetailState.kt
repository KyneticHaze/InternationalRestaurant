package com.example.internationalrestaurant.ui.screens.meal.mealDetail

import com.example.internationalrestaurant.domain.model.Meal

data class MealDetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val mealDetail : Meal? = null,
)

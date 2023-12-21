package com.example.internationalrestaurant.ui.screens.meal.meals.util

import com.example.internationalrestaurant.domain.model.Meal

data class MealState(
    val isLoading: Boolean = false,
    val error: String = "",
    val meals: List<Meal> = emptyList(),
)

package com.example.internationalrestaurant.ui.screens.meal.categoryDetail

import com.example.internationalrestaurant.domain.model.Meal

data class CategoryMealsState(
    val isLoading: Boolean = false,
    val categories : List<Meal> = emptyList(),
    val error: String = ""
)

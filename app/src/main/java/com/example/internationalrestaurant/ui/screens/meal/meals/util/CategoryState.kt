package com.example.internationalrestaurant.ui.screens.meal.meals.util

import com.example.internationalrestaurant.data.remote.category.Category

data class CategoryState(
    val isLoading: Boolean = false,
    val error: String = "",
    val category: List<Category> = emptyList()
)

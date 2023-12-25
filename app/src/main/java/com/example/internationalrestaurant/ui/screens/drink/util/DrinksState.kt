package com.example.internationalrestaurant.ui.screens.drink.util

import com.example.internationalrestaurant.domain.model.Drink

data class DrinksState(
    val isLoading: Boolean = false,
    val drinks: List<Drink> = emptyList(),
    val error: String = ""
)

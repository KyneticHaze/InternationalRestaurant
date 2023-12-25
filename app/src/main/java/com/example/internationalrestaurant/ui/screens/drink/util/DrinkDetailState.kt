package com.example.internationalrestaurant.ui.screens.drink.util

import com.example.internationalrestaurant.domain.model.Drink

data class DrinkDetailState(
    val isLoading: Boolean = false,
    val drink: Drink? = null,
    val error: String = ""
)

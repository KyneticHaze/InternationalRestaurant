package com.example.internationalrestaurant.domain.repository

import com.example.internationalrestaurant.data.remote.drink.DrinkResponse

interface DrinkRepository {

    suspend fun searchDrink(search: String) : DrinkResponse
}
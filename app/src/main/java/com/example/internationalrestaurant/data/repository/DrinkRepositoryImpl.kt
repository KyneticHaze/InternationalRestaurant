package com.example.internationalrestaurant.data.repository

import com.example.internationalrestaurant.data.remote.drink.DrinkResponse
import com.example.internationalrestaurant.data.service.DrinkAPI
import com.example.internationalrestaurant.domain.repository.DrinkRepository

class DrinkRepositoryImpl(
    private val drinkAPI: DrinkAPI
) : DrinkRepository {
    override suspend fun searchDrink(search: String): DrinkResponse = drinkAPI.searchDrink(search)
}
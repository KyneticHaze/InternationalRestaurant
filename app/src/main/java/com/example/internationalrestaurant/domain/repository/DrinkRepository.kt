package com.example.internationalrestaurant.domain.repository

import com.example.internationalrestaurant.data.remote.drink.DrinkResponse
import com.example.internationalrestaurant.domain.model.Drink
import kotlinx.coroutines.flow.Flow

interface DrinkRepository {
    suspend fun searchDrink(search: String) : DrinkResponse

    suspend fun randomDrink() : DrinkResponse

    suspend fun insertDrink(drink: Drink)

    suspend fun deleteDrink(drink: Drink)

    fun getDrinks() : Flow<List<Drink>>

}
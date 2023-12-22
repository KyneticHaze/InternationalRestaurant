package com.example.internationalrestaurant.domain.repository

import com.example.internationalrestaurant.data.remote.drink.DrinkResponse
import com.example.internationalrestaurant.domain.model.Drink

interface DrinkRepository {
    suspend fun searchDrink(search: String) : DrinkResponse

    suspend fun randomDrink() : DrinkResponse

    suspend fun insertDrink(drink: Drink)

    suspend fun deleteDrink(drink: Drink)

    suspend fun getDrink() : List<Drink>

    suspend fun getDrinkById(id : Int?) : Drink?
}
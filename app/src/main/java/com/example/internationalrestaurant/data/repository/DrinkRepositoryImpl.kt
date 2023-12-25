package com.example.internationalrestaurant.data.repository

import com.example.internationalrestaurant.data.local.DrinkDao
import com.example.internationalrestaurant.data.remote.drink.DrinkResponse
import com.example.internationalrestaurant.data.service.DrinkAPI
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow

class DrinkRepositoryImpl(
    private val drinkAPI: DrinkAPI,
    private val drinkDao: DrinkDao
) : DrinkRepository {

    override suspend fun searchDrink(search: String): DrinkResponse = drinkAPI.searchDrink(search)

    override suspend fun randomDrink(): DrinkResponse = drinkAPI.randomDrink()

    override suspend fun insertDrink(drink: Drink) = drinkDao.insertDrink(drink)

    override suspend fun deleteDrink(drink: Drink) = drinkDao.deleteDrink(drink)

    override fun getDrinks(): Flow<List<Drink>> = drinkDao.getDrinks()

}
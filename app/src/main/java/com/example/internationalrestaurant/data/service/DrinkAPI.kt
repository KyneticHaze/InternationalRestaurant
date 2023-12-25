package com.example.internationalrestaurant.data.service

import com.example.internationalrestaurant.data.remote.drink.DrinkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkAPI {

    @GET("search.php")
    suspend fun searchDrink(
        @Query("s") search: String
    ) : DrinkResponse

    @GET("random.php")
    suspend fun randomDrink() : DrinkResponse

    companion object {
        const val DRINK_BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    }
}
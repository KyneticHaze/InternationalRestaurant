package com.example.internationalrestaurant.data.service

import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {

    @GET("search.php")
    suspend fun searchMeal(
        @Query("s") search: String
    ) : MealResponse

    @GET("search.php")
    suspend fun searchMealFirstLetter(
        @Query("f") firstLetter: String
    ) : MealResponse

    @GET("lookup.php")
    suspend fun getMealById(
        @Query("i") mealId : String
    ) : MealResponse

    @GET("categories.php")
    suspend fun getCategories() : CategoriesResponse

    companion object {
        const val BASE_URL = "www.themealdb.com/api/json/v1/1/"
    }
}
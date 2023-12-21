package com.example.internationalrestaurant.data.service

import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {

    @GET("categories.php")
    suspend fun getCategories() : CategoriesResponse

    @GET("search.php")
    suspend fun allMealsFirstLetter(
        @Query("f") firstLetter: String
    ) : MealResponse

    @GET("lookup.php")
    suspend fun mealDetail(
        @Query("i") mealId: String
    ) : MealResponse

    @GET("filter.php")
    suspend fun filterCategories(
        @Query("c") filterCategory: String
    ) : MealResponse

    companion object {
        const val MEAL_BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }
}
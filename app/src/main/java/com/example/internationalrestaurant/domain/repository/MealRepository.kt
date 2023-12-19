package com.example.internationalrestaurant.domain.repository

import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse

interface MealRepository {

    suspend fun getMealById(mealId: String) : MealResponse

    suspend fun searchMeal(search: String) : MealResponse

    suspend fun searchMealFirstLetter(firstLetter: String) : MealResponse

    suspend fun getCategories() : CategoriesResponse
}
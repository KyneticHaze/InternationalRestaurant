package com.example.internationalrestaurant.domain.repository

import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse

interface MealRepository {
    suspend fun searchMeal(search: String) : MealResponse

    suspend fun getCategories() : CategoriesResponse

    suspend fun allMealsFirstLetter(firstLetter: String) : MealResponse
}
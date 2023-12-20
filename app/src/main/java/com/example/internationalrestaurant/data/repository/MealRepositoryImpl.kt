package com.example.internationalrestaurant.data.repository

import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse
import com.example.internationalrestaurant.data.service.MealAPI
import com.example.internationalrestaurant.domain.repository.MealRepository

class MealRepositoryImpl(
    private val mealAPI: MealAPI
) : MealRepository {

    override suspend fun searchMeal(search: String): MealResponse = mealAPI.searchMeal(search)

    override suspend fun getCategories(): CategoriesResponse = mealAPI.getCategories()
    override suspend fun allMealsFirstLetter(firstLetter: String): MealResponse = mealAPI.allMealsFirstLetter(firstLetter)
}
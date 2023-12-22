package com.example.internationalrestaurant.domain.repository

import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse
import com.example.internationalrestaurant.domain.model.Meal

interface MealRepository {

    suspend fun getCategories() : CategoriesResponse

    suspend fun allMealsFirstLetter(firstLetter: String) : MealResponse

    suspend fun mealDetail(mealId: String) : MealResponse

    suspend fun filterCategories(filterCategory: String) : MealResponse

    suspend fun insertMeal(meal : Meal)

    suspend fun deleteMeal(meal : Meal)

    suspend fun getMeals() : List<Meal>

    suspend fun getMealById(id : Int?) : Meal?
}
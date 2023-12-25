package com.example.internationalrestaurant.data.repository

import com.example.internationalrestaurant.data.local.MealDao
import com.example.internationalrestaurant.data.remote.category.CategoriesResponse
import com.example.internationalrestaurant.data.remote.meal.MealResponse
import com.example.internationalrestaurant.data.service.MealAPI
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow

class MealRepositoryImpl(
    private val mealAPI: MealAPI,
    private val mealDao : MealDao
) : MealRepository {

    override suspend fun getCategories(): CategoriesResponse = mealAPI.getCategories()

    override suspend fun allMealsFirstLetter(firstLetter: String): MealResponse = mealAPI.allMealsFirstLetter(firstLetter)

    override suspend fun mealDetail(mealId: String): MealResponse = mealAPI.mealDetail(mealId)

    override suspend fun filterCategories(filterCategory: String): MealResponse = mealAPI.filterCategories(filterCategory)

    override suspend fun insertMeal(meal: Meal) = mealDao.insertMeal(meal)

    override suspend fun deleteMeal(meal: Meal) = mealDao.deleteMeal(meal)

    override fun getMeals(): Flow<List<Meal>> = mealDao.getMeals()

}
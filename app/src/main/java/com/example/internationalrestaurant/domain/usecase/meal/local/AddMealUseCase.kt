package com.example.internationalrestaurant.domain.usecase.meal.local

import com.example.internationalrestaurant.common.InvalidRestaurantException
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.domain.repository.MealRepository
import javax.inject.Inject
import kotlin.jvm.Throws

class AddMealUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    @Throws(InvalidRestaurantException::class)
    suspend operator fun invoke(meal : Meal) {
        if (meal.mealId == null) {
            throw InvalidRestaurantException("Can not found meal!")
        } else {
            mealRepository.insertMeal(meal)
        }
    }
}
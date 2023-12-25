package com.example.internationalrestaurant.domain.usecase.meal.local


import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    operator fun invoke() : Flow<List<Meal>> {
        return mealRepository.getMeals()
    }
}
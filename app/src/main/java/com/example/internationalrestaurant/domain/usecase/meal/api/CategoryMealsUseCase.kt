package com.example.internationalrestaurant.domain.usecase.meal.api

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.internationalrestaurant.common.DataStats
import com.example.internationalrestaurant.data.remote.meal.toMeal
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class CategoryMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    operator fun invoke(filterCategoryStr : String) : Flow<DataStats<List<Meal>>> = flow {
        try {
            emit(DataStats.Loading())
            mealRepository.filterCategories(filterCategoryStr).meals?.map { it.toMeal() }?.let { meals ->
                emit(DataStats.Success(meals))
            }
        } catch (e : HttpException) {
            emit(DataStats.Error(e.localizedMessage ?: "Http not found!"))
        } catch (e : IOException) {
            emit(DataStats.Error(e.localizedMessage ?: "Can not found internet connection!"))
        }
    }
}
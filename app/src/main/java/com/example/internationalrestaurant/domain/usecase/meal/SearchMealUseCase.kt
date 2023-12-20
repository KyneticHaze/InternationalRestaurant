package com.example.internationalrestaurant.domain.usecase.meal

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
class SearchMealUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    operator fun invoke(search : String) : Flow<DataStats<Meal>> = flow {
        try {
            emit(DataStats.Loading())
            mealRepository.searchMeal(search).meals?.map { it.toMeal() }?.get(0)?.let {
                emit(DataStats.Success(it))
            }
        } catch (e : HttpException) {
            emit(DataStats.Error(e.localizedMessage ?: "Http not found!"))
        } catch (e : IOException) {
            emit(DataStats.Error(e.localizedMessage ?: "Can not found internet connection!"))
        }
    }
}
package com.example.internationalrestaurant.domain.usecase.drink.api

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.internationalrestaurant.common.DataStats
import com.example.internationalrestaurant.data.remote.drink.toDrink
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class RandomDrinkUseCase @Inject constructor(
    private val drinkRepository: DrinkRepository
) {
    operator fun invoke() : Flow<DataStats<Drink>> = flow {
        try {
            emit(DataStats.Loading())
            drinkRepository.randomDrink().drinks?.map { it.toDrink() }?.get(0)?.let {
                emit(DataStats.Success(it))
            }
        } catch (e : HttpException) {
            emit(DataStats.Error(e.localizedMessage ?: "Http not found!"))
        } catch (e : IOException) {
            emit(DataStats.Error(e.localizedMessage ?: "Can not found internet connection!"))
        }
    }
}
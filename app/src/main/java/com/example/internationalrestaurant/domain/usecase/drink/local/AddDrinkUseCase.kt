package com.example.internationalrestaurant.domain.usecase.drink.local

import com.example.internationalrestaurant.common.InvalidRestaurantException
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.repository.DrinkRepository
import javax.inject.Inject
import kotlin.jvm.Throws

class AddDrinkUseCase @Inject constructor(
    private val drinkRepository: DrinkRepository
) {
    @Throws(InvalidRestaurantException::class)
    suspend operator fun invoke(drink: Drink) {
        if (drink.drinkId == null) {
            throw InvalidRestaurantException("Can not found drink!")
        } else {
            drinkRepository.insertDrink(drink)
        }
    }
}
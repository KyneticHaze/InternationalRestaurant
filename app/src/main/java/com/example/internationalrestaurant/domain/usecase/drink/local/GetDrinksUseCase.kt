package com.example.internationalrestaurant.domain.usecase.drink.local

import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDrinksUseCase @Inject constructor(
    private val drinkRepository: DrinkRepository
) {
    operator fun invoke() : Flow<List<Drink>> {
        return drinkRepository.getDrinks()
    }
}
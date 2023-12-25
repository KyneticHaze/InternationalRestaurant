package com.example.internationalrestaurant.ui.screens.favorites.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.domain.usecase.drink.local.DeleteDrinkUseCase
import com.example.internationalrestaurant.domain.usecase.drink.local.GetDrinksUseCase
import com.example.internationalrestaurant.domain.usecase.meal.local.DeleteMealUseCase
import com.example.internationalrestaurant.domain.usecase.meal.local.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FavoritesScreenViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase,
    private val getDrinksUseCase: GetDrinksUseCase,
    private val deleteMealUseCase: DeleteMealUseCase,
    private val deleteDrinkUseCase: DeleteDrinkUseCase
) : ViewModel() {

    private val _mealState = mutableStateOf(MealState())
    val mealState : State<MealState>
        get() = _mealState

    private val _drinkState = mutableStateOf(DrinkState())
    val drinkState : State<DrinkState>
        get() = _drinkState

    private var job1 : Job? = null
    private var job2 : Job? = null


    init {
        getMeals()
        getDrinks()
    }

    private fun getMeals() {
        job1?.cancel()
        job1 = getMealsUseCase().onEach { meals ->
            _mealState.value = _mealState.value.copy(
                meals = meals
            )
        }.launchIn(viewModelScope)
    }

    fun deleteMeal(meal : Meal) {
        viewModelScope.launch {
            deleteMealUseCase(meal)
        }
    }

    private fun getDrinks() {
        job2?.cancel()
        job2 = getDrinksUseCase().onEach {
            _drinkState.value = _drinkState.value.copy(
                drinks = it
            )
        }.launchIn(viewModelScope)
    }

    fun deleteDrink(drink: Drink) {
        viewModelScope.launch {
            deleteDrinkUseCase(drink)
        }
    }
}

data class MealState(
    val meals : List<Meal> = emptyList()
)

data class DrinkState(
    val drinks : List<Drink> = emptyList()
)
package com.example.internationalrestaurant.ui.screens.drink.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internationalrestaurant.common.DataStats
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.usecase.drink.api.RandomDrinkUseCase
import com.example.internationalrestaurant.domain.usecase.drink.api.SearchDrinkUseCase
import com.example.internationalrestaurant.domain.usecase.drink.local.AddDrinkUseCase
import com.example.internationalrestaurant.ui.screens.drink.util.DrinkDetailState
import com.example.internationalrestaurant.ui.screens.drink.util.DrinksState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val searchDrinkUseCase: SearchDrinkUseCase,
    private val randomDrinkUseCase: RandomDrinkUseCase,
    private val addDrinkUseCase: AddDrinkUseCase
) : ViewModel() {

    private val _drinksState = mutableStateOf(DrinksState())
    val drinksState : State<DrinksState> = _drinksState

    private val _drinkDetailState = mutableStateOf(DrinkDetailState())
    val drinkDetailState : State<DrinkDetailState>
        get() = _drinkDetailState

    private var _searchQuery = mutableStateOf("")
    val searchQuery : State<String> = _searchQuery

    fun searchDrink(search : String) {
        _searchQuery.value = search
        searchDrinkUseCase(search).onEach { result ->
            when (result) {
                is DataStats.Loading -> {
                    _drinksState.value = _drinksState.value.copy(isLoading = true)
                }
                is DataStats.Success -> {
                    _drinksState.value = _drinksState.value.copy(drinks = result.data ?: emptyList())
                }
                is DataStats.Error -> {
                    _drinksState.value = _drinksState.value.copy(error = result.message ?: "Not Found Drinks!")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun clearDrink() {
        _searchQuery.value = ""
        _drinksState.value = DrinksState()
    }

    fun getDrinkDetail() {
        randomDrinkUseCase().onEach { result ->
            when (result) {
                is DataStats.Loading -> {
                    _drinkDetailState.value = _drinkDetailState.value.copy(isLoading = true)
                }
                is DataStats.Success -> {
                    _drinkDetailState.value = _drinkDetailState.value.copy(drink = result.data)
                }
                is DataStats.Error -> {
                    _drinkDetailState.value = _drinkDetailState.value.copy(error = "Drink Detail Card Not Found!")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun clearDrinkDetail() {
        _drinkDetailState.value = DrinkDetailState()
    }
    fun addDrink(drink : Drink) {
        viewModelScope.launch {
            addDrinkUseCase(drink)
        }
    }
}
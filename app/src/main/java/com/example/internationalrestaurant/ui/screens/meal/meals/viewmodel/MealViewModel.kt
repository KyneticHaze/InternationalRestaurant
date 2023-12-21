package com.example.internationalrestaurant.ui.screens.meal.meals.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internationalrestaurant.common.DataStats
import com.example.internationalrestaurant.domain.usecase.meal.AllMealsFirstLetterUseCase
import com.example.internationalrestaurant.domain.usecase.meal.GetCategoriesUseCase
import com.example.internationalrestaurant.ui.screens.meal.meals.util.CategoryState
import com.example.internationalrestaurant.ui.screens.meal.meals.util.MealState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MealViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealsFirstLetterUseCase: AllMealsFirstLetterUseCase
) : ViewModel() {

    private val _mealState = mutableStateOf(MealState())
    val mealState: State<MealState>
        get() = _mealState

    private val _categoryState = mutableStateOf(CategoryState())
    val categoryState: State<CategoryState>
        get() = _categoryState

    private var _searchQuery = mutableStateOf("")
    val searchQuery: State<String>
        get() = _searchQuery

    init {
        getCategories()
    }

    private fun getCategories() {
        getCategoriesUseCase().onEach {
            when (it) {
                is DataStats.Loading -> {
                    _categoryState.value = _categoryState.value.copy(isLoading = true)
                }

                is DataStats.Success -> {
                    _categoryState.value =
                        _categoryState.value.copy(
                            isLoading = false,
                            category = it.data ?: emptyList()
                        )
                }

                is DataStats.Error -> {
                    _categoryState.value = _categoryState.value.copy(
                        isLoading = false,
                        error = it.message ?: "Not found meal!"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getMealsFirstLetter(firsLetter: String) {
        _searchQuery.value = firsLetter
        getMealsFirstLetterUseCase(firsLetter).onEach { result ->
            when (result) {
                is DataStats.Loading -> {
                    _mealState.value = _mealState.value.copy(isLoading = true)
                }

                is DataStats.Success -> {
                    println(result.data)
                    _mealState.value =
                        _mealState.value.copy(isLoading = false, meals = result.data ?: emptyList())
                }

                is DataStats.Error -> {
                    _mealState.value = _mealState.value.copy(
                        isLoading = false,
                        error = result.message ?: "Not found meal!"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun clearMeal() {
        _searchQuery.value = ""
        _mealState.value = _mealState.value.copy(meals = emptyList())
    }
}
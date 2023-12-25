package com.example.internationalrestaurant.ui.screens.meal.categoryDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internationalrestaurant.common.DataStats
import com.example.internationalrestaurant.common.Params
import com.example.internationalrestaurant.domain.model.Meal
import com.example.internationalrestaurant.domain.usecase.meal.api.CategoryMealsUseCase
import com.example.internationalrestaurant.domain.usecase.meal.local.AddMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CategoryMealsViewModel @Inject constructor(
    private val categoryMealsUseCase: CategoryMealsUseCase,
    private val addMealUseCase: AddMealUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _categoryMealsState = mutableStateOf(CategoryMealsState())
    val categoryMealsState : State<CategoryMealsState>
        get() = _categoryMealsState

    init {
        savedStateHandle.get<String>(Params.PARAM_CATEGORY_MEALS_NAME)?.let {
            getCategoryMeals(it)
        }
    }

    private fun getCategoryMeals(filterCategoryStr : String) {
        categoryMealsUseCase(filterCategoryStr).onEach { result ->
            when (result) {
                is DataStats.Loading -> {
                    _categoryMealsState.value = _categoryMealsState.value.copy(isLoading = true)
                }
                is DataStats.Success -> {
                    _categoryMealsState.value = _categoryMealsState.value.copy(isLoading = false, categories = result.data ?: emptyList())
                }
                is DataStats.Error -> {
                    _categoryMealsState.value = _categoryMealsState.value.copy(isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun addCategoryMeal(meal : Meal) {
        viewModelScope.launch {
            addMealUseCase(meal)
        }
    }
}
package com.example.internationalrestaurant.ui.screens.meal.mealDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internationalrestaurant.common.DataStats
import com.example.internationalrestaurant.common.Params
import com.example.internationalrestaurant.domain.usecase.meal.api.MealDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MealDetailViewModel @Inject constructor(
    private val mealDetailUseCase: MealDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _mealDetailState = mutableStateOf(MealDetailState())
    val mealDetailState : State<MealDetailState>
        get() = _mealDetailState

    init {
        savedStateHandle.get<String>(Params.PARAM_MEAL_ID)?.let {
            getMealDetail(it)
        }
    }

    private fun getMealDetail(mealId : String) {
        mealDetailUseCase(mealId).onEach { result ->
            when (result) {
                is DataStats.Loading -> {
                    _mealDetailState.value = _mealDetailState.value.copy(isLoading = true)
                }
                is DataStats.Success -> {
                    _mealDetailState.value = _mealDetailState.value.copy(
                        isLoading = false,
                        mealDetail = result.data
                    )
                }
                is DataStats.Error -> {
                 _mealDetailState.value = _mealDetailState.value.copy(
                     error = "Meal Detail Card not found!"
                 )
                }
            }
        }.launchIn(viewModelScope)
    }
}
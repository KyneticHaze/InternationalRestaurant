package com.example.internationalrestaurant.data.remote.meal


import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals")
    val meals: List<Meal>?
)
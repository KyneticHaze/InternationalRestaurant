package com.example.internationalrestaurant.domain.model

data class Meal(
    val mealId : String?,
    val mealName : String?,
    val mealImg : String?,
    val mealDesc : String?,
    val deeplink : String?,
    val mealCountry : String?,
    val category : String?
)

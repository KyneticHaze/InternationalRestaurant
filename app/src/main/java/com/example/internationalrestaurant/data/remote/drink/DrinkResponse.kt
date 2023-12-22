package com.example.internationalrestaurant.data.remote.drink


import com.google.gson.annotations.SerializedName

data class DrinkResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkDTO>?
)
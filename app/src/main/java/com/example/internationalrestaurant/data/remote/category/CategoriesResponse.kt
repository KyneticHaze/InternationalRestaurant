package com.example.internationalrestaurant.data.remote.category


import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<Category>?
)
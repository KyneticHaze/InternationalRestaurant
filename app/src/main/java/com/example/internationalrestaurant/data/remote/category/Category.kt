package com.example.internationalrestaurant.data.remote.category


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val id: String?,
    @SerializedName("strCategory")
    val categoryName: String?,
    @SerializedName("strCategoryDescription")
    val categoryDesc: String?,
    @SerializedName("strCategoryThumb")
    val categoryImg: String?
)
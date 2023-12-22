package com.example.internationalrestaurant.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("meal_table")
data class Meal(
    @ColumnInfo(name = "meal_id") val mealId : String?,
    @ColumnInfo(name = "meal_name") val mealName : String?,
    @ColumnInfo(name = "meal_image") val mealImg : String?,
    @ColumnInfo(name = "meal_description") val mealDesc : String?,
    @ColumnInfo(name = "meal_link") val deeplink : String?,
    @ColumnInfo(name = "meal_country") val mealCountry : String?,
    @ColumnInfo(name = "mal_category") val category : String?,
    @PrimaryKey val id : Int? = null
)

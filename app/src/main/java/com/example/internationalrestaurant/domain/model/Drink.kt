package com.example.internationalrestaurant.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("drink_table")
data class Drink(
    @ColumnInfo(name = "drink_id") val drinkId : String?,
    @ColumnInfo(name = "drink_name") val drinkName : String?,
    @ColumnInfo(name = "drink_description") val drinkDesc : String?,
    @ColumnInfo(name = "drink_image") val drinkImage : String?,
    @ColumnInfo(name = "drink_category") val drinkCategory : String?,
    @ColumnInfo(name = "drink_glass") val drinkGlass : String?,
    @ColumnInfo(name = "drink_alcoholic") val drinkAlcoholic : String?,
    @PrimaryKey val id : Int? = null
)
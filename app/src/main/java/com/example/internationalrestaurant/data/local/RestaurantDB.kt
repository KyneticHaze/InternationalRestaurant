package com.example.internationalrestaurant.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.domain.model.Meal

@Database(entities = [Meal::class, Drink::class], version = 1)
abstract class RestaurantDB : RoomDatabase() {
    abstract fun mealDao() : MealDao
    abstract fun drinkDao() : DrinkDao

    companion object {
        const val DB_NAME = "restaurant_db"
    }
}
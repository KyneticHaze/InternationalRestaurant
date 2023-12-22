package com.example.internationalrestaurant.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.internationalrestaurant.domain.model.Meal

@Dao
interface MealDao {

    @Query("SELECT * FROM meal_table")
    suspend fun getMeals() : List<Meal>

    @Query("SELECT * FROM meal_table WHERE id = :mealId")
    suspend fun getMealsById(mealId : Int?) : Meal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: Meal)

    @Delete
    suspend fun deleteMeal(meal: Meal)
}
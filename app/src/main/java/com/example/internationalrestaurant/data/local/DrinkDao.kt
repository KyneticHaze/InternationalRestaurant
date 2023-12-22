package com.example.internationalrestaurant.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.internationalrestaurant.domain.model.Drink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drink_table")
    suspend fun getDrinks() : List<Drink>

    @Query("SELECT * FROM drink_table WHERE id = :drinkId")
    suspend fun getMealsById(drinkId : Int?) : Drink?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: Drink)

    @Delete
    suspend fun deleteDrink(drink: Drink)
}
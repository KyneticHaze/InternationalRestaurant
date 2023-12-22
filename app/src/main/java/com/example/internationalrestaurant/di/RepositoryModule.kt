package com.example.internationalrestaurant.di

import com.example.internationalrestaurant.data.local.DrinkDao
import com.example.internationalrestaurant.data.local.MealDao
import com.example.internationalrestaurant.data.local.RestaurantDB
import com.example.internationalrestaurant.data.repository.DrinkRepositoryImpl
import com.example.internationalrestaurant.data.repository.MealRepositoryImpl
import com.example.internationalrestaurant.data.service.DrinkAPI
import com.example.internationalrestaurant.data.service.MealAPI
import com.example.internationalrestaurant.domain.repository.DrinkRepository
import com.example.internationalrestaurant.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMealRepository(mealAPI: MealAPI, db: RestaurantDB): MealRepository =
        MealRepositoryImpl(mealAPI, db.mealDao())

    @Provides
    @Singleton
    fun provideDrinkRepository(drinkAPI: DrinkAPI, db: RestaurantDB): DrinkRepository =
        DrinkRepositoryImpl(drinkAPI, db.drinkDao())
}
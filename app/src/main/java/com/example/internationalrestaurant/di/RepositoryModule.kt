package com.example.internationalrestaurant.di

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
    fun provideMealRepository(mealAPI: MealAPI) : MealRepository = MealRepositoryImpl(mealAPI)

    @Provides
    @Singleton
    fun provideDrinkRepository(drinkAPI: DrinkAPI) : DrinkRepository = DrinkRepositoryImpl(drinkAPI)
}
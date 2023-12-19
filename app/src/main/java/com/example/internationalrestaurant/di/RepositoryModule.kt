package com.example.internationalrestaurant.di

import com.example.internationalrestaurant.data.repository.MealRepositoryImpl
import com.example.internationalrestaurant.data.service.MealAPI
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
    fun provideMealRepository(mealAPI: MealAPI) = MealRepositoryImpl(mealAPI)
}
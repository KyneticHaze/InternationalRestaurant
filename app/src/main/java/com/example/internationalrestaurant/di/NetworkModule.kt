package com.example.internationalrestaurant.di

import com.example.internationalrestaurant.data.service.DrinkAPI
import com.example.internationalrestaurant.data.service.MealAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMealAPI(): MealAPI {
        return Retrofit.Builder()
            .baseUrl(MealAPI.MEAL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideDrinkAPI(): DrinkAPI {
        return Retrofit.Builder()
           .baseUrl(DrinkAPI.DRINK_BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(DrinkAPI::class.java)
    }
}
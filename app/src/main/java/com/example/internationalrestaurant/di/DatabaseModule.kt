package com.example.internationalrestaurant.di

import android.app.Application
import androidx.room.Room
import com.example.internationalrestaurant.data.local.RestaurantDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): RestaurantDB {
        return Room.databaseBuilder(
            app,
            RestaurantDB::class.java,
            RestaurantDB.DB_NAME
        ).build()
    }
}
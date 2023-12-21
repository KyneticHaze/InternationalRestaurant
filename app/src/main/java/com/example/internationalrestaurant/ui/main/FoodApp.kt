package com.example.internationalrestaurant.ui.main

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.internationalrestaurant.ui.navigation.MainNavigationBar
import com.example.internationalrestaurant.ui.navigation.NavGraphComponent

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun FoodApp() {

    val navController = rememberNavController()


    Scaffold(
        bottomBar = {
            MainNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavGraphComponent(navHostController = navController, paddingValues)
    }
}
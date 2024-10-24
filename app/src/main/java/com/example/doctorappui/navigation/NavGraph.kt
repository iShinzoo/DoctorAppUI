package com.example.doctorappui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doctorappui.CartScreen
import com.example.doctorappui.DetailsScreen
import com.example.doctorappui.HomeScreen
import com.example.doctorappui.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.WelcomeScreen.name,
    ) {
        composable(Route.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(Route.WelcomeScreen.name) {
            WelcomeScreen(navController)
        }
        composable(Route.DetailsScreen.name) {
            DetailsScreen(navController)
        }
        composable(Route.CartScreen.name) {
            CartScreen(navController)
        }
    }
}

package com.example.app10

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.menu
    ) {

        composable(Routes.menu) {
            Menu(navController)
        }

        composable(Routes.cities) {
            Cities(navController)
        }

        composable(Routes.buildings) {
            Buildings(navController)
        }

        composable(Routes.about + "/{direction}/{year}") { backStackEntry ->
            val direction = backStackEntry.arguments?.getString("direction") ?: ""
            val year = backStackEntry.arguments?.getString("year") ?: ""

            About(navController, direction, year)
        }
    }
}
package com.example.individualproject3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainpage") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginPage(navController) }
        composable("registration") { RegistrationPage(navController) }
        composable("mainpage") { MainScreenPage(navController) }
        composable("easy") { Easy(navController) }
        composable("medium") { Medium(navController) }
        composable("street") { StreetGamePage(navController) }
    }
}
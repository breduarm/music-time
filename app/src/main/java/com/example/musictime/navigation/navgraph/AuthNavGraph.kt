package com.example.musictime.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.domain.usecases.UserUsesCases
import com.example.musictime.navigation.Screen
import com.example.musictime.presentation.screens.login.LoginScreen
import com.example.musictime.presentation.screens.login.LoginViewModel
import com.example.musictime.presentation.screens.signup.SignUpScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(rootNavController)
        }

        composable(route = Screen.SignUp.route) {
            SignUpScreen(rootNavController)
        }

    }
}
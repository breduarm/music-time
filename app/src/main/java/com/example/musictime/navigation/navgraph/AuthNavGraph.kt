package com.example.musictime.navigation.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.core.Graph
import com.example.musictime.core.Screen
import com.example.musictime.home.HomeScreen
import com.example.musictime.login.LoginScreen
import com.example.musictime.presentation.screens.signup.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.AUTH,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            val viewModel: AuthNavViewModel = hiltViewModel()
            if(viewModel.isLogged == 0){ HomeScreen(paddingValues = PaddingValues(all = 0.dp), navController = rootNavController) }
            else if(viewModel.isLogged == 1) { LoginScreen(rootNavController) }
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(rootNavController)
        }
    }
}
package com.example.musictime.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.navigation.Screen
import com.example.musictime.presentation.screens.on_boarding.OnBoardingScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
fun NavGraphBuilder.welcomeNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.WELCOME,
        startDestination = Screen.OnBoarding.route
    ) {
        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(rootNavController = rootNavController)
        }
    }
}

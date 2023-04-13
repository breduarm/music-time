package com.example.musictime.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.core.Graph
import com.example.musictime.core.Screen
import com.example.musictime.onboarding.navigation.onBoardingRoute
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
fun NavGraphBuilder.welcomeNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.WELCOME,
        startDestination = Screen.OnBoarding.route
    ) {

        composable(route = Screen.Login.route){

        }

        onBoardingRoute(
            navigateToAuth = {
                rootNavController.popBackStack()
                rootNavController.navigate(Graph.AUTH)
            }
        )
    }
}

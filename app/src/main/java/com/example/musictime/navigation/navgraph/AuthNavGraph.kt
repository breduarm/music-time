package com.example.musictime.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.navigation.Screen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            //TODO Login Screen
        }
    }
}
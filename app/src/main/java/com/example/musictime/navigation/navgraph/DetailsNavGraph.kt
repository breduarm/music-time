package com.example.musictime.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.navigation.Screen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = ""
    ) {
        composable(route = Screen.MusicPlayer.route) {
            //TODO MusicPlayer Screen
        }
    }
}
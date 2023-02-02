package com.example.musictime.bottombar.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.core.Graph
import com.example.musictime.core.Screen
import com.example.musictime.musicplayer.MusicPlayerScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = Screen.MusicPlayer.route
    ) {
        composable(route = Screen.MusicPlayer.route) {
            MusicPlayerScreen(detailsNavController = navController)
        }
    }
}
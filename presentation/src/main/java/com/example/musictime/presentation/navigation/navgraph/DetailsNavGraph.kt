package com.example.musictime.presentation.navigation.navgraph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictime.presentation.navigation.Screen
import com.example.musictime.presentation.screens.music_player.MusicPlayerScreen

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
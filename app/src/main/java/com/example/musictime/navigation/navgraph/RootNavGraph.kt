package com.example.musictime.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musictime.presentation.screens.bottombar.BottomBarScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = rootNavController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        welcomeNavGraph(rootNavController = rootNavController)
        authNavGraph(rootNavController = rootNavController)
        composable(route = Graph.BOTTOM) {
            BottomBarScreen(
                rootNavController = rootNavController
            )
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val WELCOME = "welcome_graph"
    const val BOTTOM = "bottom_graph"
    const val DETAILS = "details_graph"
}

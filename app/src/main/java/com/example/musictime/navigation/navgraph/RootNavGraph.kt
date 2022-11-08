package com.example.musictime.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun RootNavGraph(rootNavController: NavHostController) {
    NavHost(
        navController = rootNavController,
        route = Graph.ROOT,
        startDestination = Graph.WELCOME
    ) {
        welcomeNavGraph(rootNavController = rootNavController)
        authNavGraph(rootNavController = rootNavController)
        composable(route = Graph.BOTTOM) {
            //TODO BottomBar Screen
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

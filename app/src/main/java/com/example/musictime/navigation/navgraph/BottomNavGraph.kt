package com.example.musictime.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.musictime.navigation.BottomBarScreen

@Composable
fun BottomNavGraph(navController: NavHostController, rootNavController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.BOTTOM,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            //TODO Home Screen
        }
        composable(route = BottomBarScreen.Search.route) {
            //TODO Search Screen
        }
        composable(route = BottomBarScreen.Favourites.route) {
            //TODO Favourites Screen
        }
        detailsNavGraph(navController)
    }
}
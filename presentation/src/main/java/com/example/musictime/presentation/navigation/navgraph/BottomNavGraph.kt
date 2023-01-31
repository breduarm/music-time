package com.example.musictime.presentation.navigation.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.musictime.presentation.screens.favourites.FavouritesScreen
import com.example.musictime.presentation.screens.home.HomeScreen
import com.example.musictime.presentation.screens.search.SearchScreen

@ExperimentalComposeUiApi
@Composable
fun BottomNavGraph(paddingValues: PaddingValues, navController: NavHostController, rootNavController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.BOTTOM,
        startDestination = com.example.musictime.presentation.navigation.BottomBarScreen.Home.route
    ) {
        composable(route = com.example.musictime.presentation.navigation.BottomBarScreen.Home.route) {
            HomeScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        composable(route = com.example.musictime.presentation.navigation.BottomBarScreen.Search.route) {
            SearchScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        composable(route = com.example.musictime.presentation.navigation.BottomBarScreen.Favourites.route) {
            FavouritesScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        detailsNavGraph(navController)
    }
}
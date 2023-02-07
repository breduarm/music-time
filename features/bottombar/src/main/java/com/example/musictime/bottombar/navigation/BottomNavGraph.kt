package com.example.musictime.bottombar.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.musictime.core.BottomBarScreen
import com.example.musictime.core.Graph
import com.example.musictime.favourites.FavouritesScreen
import com.example.musictime.home.HomeScreen
import com.example.musictime.search.SearchScreen

@ExperimentalComposeUiApi
@Composable
fun BottomNavGraph(paddingValues: PaddingValues, navController: NavHostController, rootNavController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.BOTTOM,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        composable(route = BottomBarScreen.Favourites.route) {
            FavouritesScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        detailsNavGraph(navController)
    }
}
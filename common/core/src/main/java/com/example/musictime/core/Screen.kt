package com.example.musictime.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    object OnBoarding: Screen("onboarding_screen")
    object Login: Screen("login_screen")
    object SignUp: Screen("signup_screen")
    object Search: Screen("search_screen")
    object Favourites: Screen("favourites_screen")
    object MusicPlayer: Screen("music_player_screen")
    object Details: Screen("details_screen")
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home_screen",
        title = "Home",
        icon = Icons.Outlined.Home
    )

    object Search : BottomBarScreen(
        route = "search_screen",
        title = "Search",
        icon = Icons.Outlined.Search
    )

    object Favourites : BottomBarScreen(
        route = "favourites_screen",
        title = "Favourite",
        icon = Icons.Default.Settings
    )
}

val bottomScreens = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Search,
    BottomBarScreen.Favourites
)
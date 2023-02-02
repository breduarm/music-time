package com.example.musictime.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musictime.bottombar.navigation.BottomNavGraph
import com.example.musictime.core.BottomBarScreen
import com.example.musictime.core.bottomScreens

@ExperimentalComposeUiApi
@Composable
fun BottomBarScreen(
    navController: NavHostController = rememberNavController(),
    rootNavController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
    ) { paddingValues ->
        BottomNavGraph(
            paddingValues = paddingValues,
            navController = navController,
            rootNavController = rootNavController
        )
    }
}

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = bottomScreens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation {
            bottomScreens.forEach { bottomBarScreen ->
                AddItem(
                    bottomBarScreen = bottomBarScreen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    bottomBarScreen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = { Text(text = bottomBarScreen.title) },
        icon = {
            Icon(
                imageVector = bottomBarScreen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == bottomBarScreen.route } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(bottomBarScreen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

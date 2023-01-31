package com.example.musictime.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationDrawerItem(
    val icon: ImageVector,
    val label: String
) {
    object Payments: NavigationDrawerItem(
        icon = Icons.Filled.CreditCard,
        label = "Payments"
    )
    object Settings: NavigationDrawerItem(
        icon = Icons.Filled.Settings,
        label = "Settings"
    )
    object Logout: NavigationDrawerItem(
        icon = Icons.Filled.Logout,
        label = "Logout"
    )
}
package com.example.musictime.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeTopBar(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            title = {
                Text(
                    text = "Welcome!",
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                HomeTopBarActions()
            }
        )
    }
}
@Composable
fun HomeTopBarActions() {
    NotificationsAction()
    ShareAction()
    ProfileAction()
}

@Composable
fun NotificationsAction() {
    IconButton(
        onClick = { /*TODO notification icon action*/ }
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications Icon"
        )
    }
}

@Composable
fun ShareAction() {
    IconButton(
        onClick = { /*TODO share icon action*/ }
    ) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "Share Icon"
        )
    }
}

@Composable
fun ProfileAction() {
    IconButton(
        onClick = { /*TODO profile icon action*/ }
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "AccountCircle Icon"
        )
    }
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar(navController = rememberNavController())
}
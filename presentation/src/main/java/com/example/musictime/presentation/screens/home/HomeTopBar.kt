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
import com.example.musictime.theme.colorPrimary

@Composable
fun HomeTopBar(
    navController: NavController,
    onProfileClick: () -> Unit
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
                    color = Color.White,
                    text = "Welcome!",
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                HomeTopBarActions(onProfileClick)
            }
        )
    }
}
@Composable
fun HomeTopBarActions(onProfileClick: () -> Unit) {
    NotificationsAction()
    ShareAction()
    ProfileAction(onProfileClick)
}

@Composable
fun NotificationsAction() {
    IconButton(
        onClick = { /*TODO notification icon action*/ }
    ) {
        Icon(
            tint = Color.White,
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
            tint = Color.White,
            imageVector = Icons.Default.Share,
            contentDescription = "Share Icon"
        )
    }
}

@Composable
fun ProfileAction(onProfileClick: () -> Unit) {
    IconButton(
        onClick = { onProfileClick() }
    ) {
        Icon(
            tint = Color.White,
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "AccountCircle Icon"
        )
    }
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar(navController = rememberNavController()) {}
}
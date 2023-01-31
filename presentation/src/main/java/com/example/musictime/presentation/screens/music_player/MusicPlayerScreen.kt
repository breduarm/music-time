package com.example.musictime.presentation.screens.music_player

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@ExperimentalComposeUiApi
@Composable
fun MusicPlayerScreen(
    detailsNavController: NavHostController
) {
    Scaffold(
        topBar = { MusicPlayerTopBar() },
        backgroundColor = MaterialTheme.colors.primary
    ) { paddingValues ->
        MusicPlayerContent(
            paddingValues = paddingValues
        )
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun MusicPlayerScreenPreview() {
    MusicPlayerScreen(detailsNavController = rememberNavController())
}
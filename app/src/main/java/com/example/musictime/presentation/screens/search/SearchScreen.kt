package com.example.musictime.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.ui.theme.onBoardingScreenBackgroundColor

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.onBoardingScreenBackgroundColor)
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.Black),
    ) {
        SearchTopBar()
        SearchContent()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(paddingValues = PaddingValues(), navController = rememberNavController())
}
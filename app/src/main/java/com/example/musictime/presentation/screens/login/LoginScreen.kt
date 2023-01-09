package com.example.musictime.presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.musictime.R
import com.example.musictime.navigation.navgraph.Graph

@Composable
fun LoginScreen(
    rootNavController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                rootNavController.popBackStack()
                rootNavController.navigate(Graph.BOTTOM)
            },
            text = stringResource(R.string.login_screen)
        )
    }
}
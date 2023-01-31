package com.example.musictime.presentation.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musictime.theme.colorPrimary

@Composable
fun SearchTopBar() {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        TopAppBar(
            backgroundColor = colorPrimary,
            elevation = 0.dp,
            title = {
                Text(
                    text = "Search",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        )
    }
}
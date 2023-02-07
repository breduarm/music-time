package com.example.musictime.musicplayer

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musictime.theme.topAppBarContentColor

@Composable
fun MusicPlayerTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Music Player",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back Icon",
                    tint = MaterialTheme.colors.topAppBarContentColor
                )
            }
        },
        actions = {
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "More Horizontal Icon",
                    tint = MaterialTheme.colors.topAppBarContentColor
                )
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@Preview
@Composable
fun MusicPlayerTopBarPreview() {
    MusicPlayerTopBar()
}
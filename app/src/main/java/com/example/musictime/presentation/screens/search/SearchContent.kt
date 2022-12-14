package com.example.musictime.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musictime.component.SearchTrackInputField
import com.example.musictime.component.TrackItemLarge
import com.example.musictime.ui.theme.onBoardingScreenBackgroundColor

@Composable
fun SearchContent() {
    SearchTrackInputField(
        modifier = Modifier
            .background(MaterialTheme.colors.onBoardingScreenBackgroundColor)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 12.dp),
        text = remember {
            mutableStateOf("")
        },
        onSearchClicked = {}
    )
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colors.onBoardingScreenBackgroundColor)
            .fillMaxSize()
            .padding(start = 16.dp),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) {
            TrackItemLarge()
        }
    }
}
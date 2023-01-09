package com.example.musictime.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.component.TrackItem
import com.example.musictime.ui.theme.colorSecondary
import com.example.musictime.ui.theme.onBoardingScreenBackgroundColor

@Composable
fun HomeContent(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.onBoardingScreenBackgroundColor)
    ) {
        Text(
            color = colorSecondary,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(start = 12.dp),
            text = "Top 10 World",
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) {
                TrackItem()
            }
        }
        Text(
            color = colorSecondary,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(start = 12.dp),
            text = "Top 10 in your country",
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) {
                TrackItem()
            }
        }
        Text(
            color = colorSecondary,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(start = 12.dp),
            text = "Rock",
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) {
                TrackItem()
            }
        }
        Text(
            color = colorSecondary,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(start = 12.dp),
            text = "Pop",
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) {
                TrackItem()
            }
        }
        Text(
            color = colorSecondary,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(start = 12.dp),
            text = "Latin",
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) {
                TrackItem()
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeContentPreview() {
    HomeContent(navController = rememberNavController(), paddingValues = PaddingValues())
}
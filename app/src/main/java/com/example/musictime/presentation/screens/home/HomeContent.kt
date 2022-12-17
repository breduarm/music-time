package com.example.musictime.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.component.TrackItem

@Composable
fun HomeContent(
    navController: NavHostController
) {
    Text(
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

@Preview(showSystemUi = true)
@Composable
fun HomeContentPreview() {
    HomeContent(navController = rememberNavController())
}
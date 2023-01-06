package com.example.musictime.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.musictime.R

@Composable
fun TrackItem() {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(160.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(120.dp),
            model = ImageRequest
                .Builder(LocalContext.current)
                .data("https://www.mondosonoro.com/wp-content/uploads/2020/04/strokes-new-abnormal.jpg")
                .crossfade(durationMillis = 1000)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_placeholder),
            error = painterResource(id = R.drawable.ic_placeholder),
            contentScale = ContentScale.Crop,
            contentDescription = "Image of the track"
        )
        Text(
            text = "The Adults Are Talking",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TrackItemPreview() {
    TrackItem()
}
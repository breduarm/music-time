package com.example.musictime.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun TrackItemLarge() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.size(48.dp),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data("https://www.mondosonoro.com/wp-content/uploads/2020/04/strokes-new-abnormal.jpg")
                    .build(),
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                error = painterResource(id = R.drawable.ic_placeholder),
                contentScale = ContentScale.Crop,
                contentDescription = "Image of the track"
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = "The Adults Are Talking",
                    maxLines = 1,
                    fontStyle = MaterialTheme.typography.subtitle1.fontStyle,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                Text(
                    text = "The Strokes",
                    maxLines = 1,
                    fontStyle = MaterialTheme.typography.caption.fontStyle,
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
            }
        }
        IconButton(
            onClick = {  }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                tint = Color.LightGray.copy(alpha = 0.5f),
                contentDescription = "MoreVert Icon"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackItemLargePreview() {
    TrackItemLarge()
}
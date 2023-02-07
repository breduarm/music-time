package com.example.musictime.musicplayer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.musictime.components.CircularSlider
import com.example.theme.R
import com.example.musictime.theme.EXTRA_SMALL_PADDING

@ExperimentalComposeUiApi
@Composable
fun MusicPlayerContent(
    paddingValues: PaddingValues,
    musicImage: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(top = EXTRA_SMALL_PADDING),
                text = "The Runner",
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Text(
                modifier = Modifier
                    .padding(vertical = EXTRA_SMALL_PADDING),
                text = "Foals",
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 1
            )
        }
        Box(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(Color.LightGray)) {
                        append("00:11  |  ")
                    }
                    withStyle(style = SpanStyle(Color.DarkGray)) {
                        append("03:43")
                    }
                },
                modifier = Modifier.align(Alignment.TopCenter)
            )
            CircularSlider(
                modifier = Modifier.size(300.dp)
            )
            AsyncImage(
                modifier = Modifier
                    .size(240.dp)
                    .clip(CircleShape),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(musicImage)
                    .crossfade(1000)
                    .build(),
                placeholder = painterResource(id = R.drawable.ic_circular_placeholder),
                error = painterResource(id = R.drawable.ic_circular_placeholder),
                contentScale = ContentScale.Crop,
                contentDescription = "Image of the Song",
            )
        }
        Column(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.DoNotDisturb,
                        contentDescription = "Remove Song Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(48.dp),
                        imageVector = Icons.Default.SkipPrevious,
                        contentDescription = "Skip Previous Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(72.dp),
                        imageVector = Icons.Default.PlayCircle,
                        contentDescription = "Play Circle Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(48.dp),
                        imageVector = Icons.Default.SkipNext,
                        contentDescription = "Skip Next Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite Icon"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.Shuffle,
                        contentDescription = "Shuffle Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "List Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.GraphicEq,
                        contentDescription = "Equalizer Icon"
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.Cached,
                        contentDescription = "Repeat Icon"
                    )
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun MusicPlayerContentPreview() {
    MusicPlayerContent(
        paddingValues = PaddingValues()
    )
}
package com.example.musictime.auth.google

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musictime.R
import com.example.musictime.ui.theme.MusictimeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun GoogleSignInButtonUi(
    text: String,
    loadingText: String,
    onClicked: () -> Unit
) {

    var clicked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Button(
        onClick = { clicked = !clicked },
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, start = 16.dp)
            .height(60.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = ButtonDefaults.elevation(defaultElevation = 3.dp),
        shape = CircleShape,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = "Google sign up button",
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (clicked) loadingText else text)

            if (clicked) {

                Spacer(modifier = Modifier.width(20.dp))

                CircularProgressIndicator(
                    modifier = Modifier
                        .size(30.dp),
                    strokeWidth = 3.dp,
                    color = MaterialTheme.colors.background
                )

                onClicked()

                coroutineScope.launch {
                    delay(2000)
                    clicked = false
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewGoogleSignInButtonUi() {
    MusictimeTheme {
        GoogleSignInButtonUi(
            text = "Sign Up With Google",
            "Signing in..."
        ) {}
    }
}
package com.example.musictime.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White

val colorPrimary = Color(0xFF222838)
val colorSecondary = Color(0xFFFED0D2)
val colorTernary = Color(0xFFC8F0D6)
val colorDefault = Color(0xFFe8e8e8)

val Colors.onBoardingScreenBackgroundColor get() = if(isLight) colorPrimary else colorPrimary
val Colors.titleColor get() = if(isLight) White else White
val Colors.descriptionColor get() = if(isLight) colorSecondary else colorSecondary
val Colors.activateIndicatorColor get() = if(isLight) colorTernary else colorTernary
val Colors.inactivateIndicatorColor get() = if(isLight) LightGray else DarkGray
val Colors.buttonBackgroundColor get() = if(isLight) colorTernary else colorTernary
val Colors.topAppBarContentColor: Color get() = if (isLight) colorSecondary else colorSecondary
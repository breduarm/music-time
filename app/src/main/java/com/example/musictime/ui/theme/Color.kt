package com.example.musictime.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.musictime.R

/*
val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.onBoardingScreenBackgroundColor get() = if(isLight) Color.White else Color.Black
val Colors.titleColor get() = if(isLight) DarkGray else LightGray
val Colors.descriptionColor get() = if(isLight) DarkGray.copy(alpha = 0.5f) else LightGray.copy(alpha = 0.5f)
val Colors.activateIndicatorColor get() = if(isLight) Purple500 else Purple700
val Colors.inactivateIndicatorColor get() = if(isLight) LightGray else DarkGray
val Colors.buttonBackgroundColor get() = if(isLight) Purple500 else Purple700
val Colors.topAppBarContentColor: Color get() = if (isLight) Color.White else LightGray

 */




/** Theme 1 val colorPrimary = Color(0xFF3F4a66) */

/** Theme 2 val colorPrimary = Color(0xFFEAEDFA)  val colorPrimary = Color(R.color.colorPrimary) */


val colorPrimary = Color(0xFF222838)
val colorSecondary = Color(0xFFFED0D2)
val colorTernary = Color(0xFFC8F0D6)


val Colors.onBoardingScreenBackgroundColor get() = if(isLight) colorPrimary else colorPrimary
val Colors.titleColor get() = if(isLight) White else White
val Colors.descriptionColor get() = if(isLight) colorSecondary else colorSecondary
val Colors.activateIndicatorColor get() = if(isLight) colorTernary else colorTernary
val Colors.inactivateIndicatorColor get() = if(isLight) LightGray else DarkGray
val Colors.buttonBackgroundColor get() = if(isLight) colorTernary else colorTernary
val Colors.topAppBarContentColor: Color get() = if (isLight) colorSecondary else colorSecondary
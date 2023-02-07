package com.example.musictime.presentation.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.musictime.login.VersionEnd
import com.example.musictime.theme.colorPrimary

@Composable
fun SignUpScreen(
    rootNavController: NavHostController,
    viewModel: SignUpViewModel = hiltViewModel()

){
    Box(
    modifier = Modifier
        .background(colorPrimary)
        .fillMaxSize()
        .padding(16.dp),
    ) {
        SignUp(Modifier.align(Alignment.TopStart), viewModel, rootNavController)
        VersionEnd(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun SignUp(modifier: Modifier, viewModel: SignUpViewModel, rootNavController: NavHostController) {
    Column(modifier = modifier) {
        Text(
            text = "Epa",
            modifier = modifier.clickable { rootNavController.popBackStack() },
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

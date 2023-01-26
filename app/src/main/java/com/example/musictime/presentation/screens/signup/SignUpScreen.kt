package com.example.musictime.presentation.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.musictime.presentation.screens.login.LoginViewModel
import com.example.musictime.presentation.screens.login.VersionEnd
import com.example.musictime.ui.theme.colorPrimary

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

}

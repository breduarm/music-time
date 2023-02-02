package com.example.musictime.onboarding.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.musictime.core.Screen
import com.example.musictime.onboarding.OnBoardingScreen
import com.example.musictime.onboarding.OnBoardingViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
fun NavGraphBuilder.onBoardingRoute(
    navigateToAuth: () -> Unit
) {
    composable(route = Screen.OnBoarding.route) {
        val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()

        OnBoardingScreen(
            navigateToAuth = navigateToAuth,
            saveOnBoardingPageState = { onBoardingViewModel.saveOnBoardingPageState(true) }
        )
    }
}
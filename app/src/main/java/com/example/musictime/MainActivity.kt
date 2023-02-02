package com.example.musictime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.navigation.navgraph.RootNavGraph
import com.example.musictime.splash.SplashViewModel
import com.example.musictime.theme.MusictimeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel
    private lateinit var rootNavController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading
        }

        setContent {
            MusictimeTheme {
                val startDestination = splashViewModel.startDestination
                rootNavController = rememberNavController()
                RootNavGraph(
                    rootNavController = rootNavController,
                    startDestination = startDestination
                )
            }
        }
    }
}

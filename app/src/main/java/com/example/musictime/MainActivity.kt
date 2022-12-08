package com.example.musictime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.navigation.navgraph.RootNavGraph
import com.example.musictime.ui.theme.MusictimeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var rootNavController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusictimeTheme {
                rootNavController = rememberNavController()
                RootNavGraph(rootNavController = rootNavController)
            }
        }
    }
}

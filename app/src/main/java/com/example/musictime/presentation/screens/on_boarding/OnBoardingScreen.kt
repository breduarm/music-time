package com.example.musictime.presentation.screens.on_boarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.R
import com.example.musictime.domain.model.OnBoardingPage
import com.example.musictime.navigation.navgraph.Graph
import com.example.musictime.ui.theme.*
import com.google.accompanist.pager.*

@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(
    rootNavController: NavHostController,
    onBoardingScreenViewModel: OnBoardingScreenViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onBoardingScreenBackgroundColor),
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = pages.size,
            state = pagerState
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activateIndicatorColor,
            inactiveColor = MaterialTheme.colors.inactivateIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState,
            pageCount = pages.size
        ) {
            rootNavController.popBackStack()
            rootNavController.navigate(Graph.AUTH)
            onBoardingScreenViewModel.saveOnBoardingPageState(true)
        }
    }
}

@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SMALL_PADDING),
            text = onBoardingPage.title,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.titleColor,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.descriptionColor,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    pageCount: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == pageCount - 1
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview() {
    OnBoardingScreen(
        rootNavController = rememberNavController()
    )
}

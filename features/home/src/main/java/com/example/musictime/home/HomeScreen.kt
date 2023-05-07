package com.example.musictime.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.musictime.core.Screen
import com.example.musictime.theme.colorPrimary
import com.example.musictime.theme.colorSecondary
import com.example.theme.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        scaffoldState = scaffoldState,
        backgroundColor = colorPrimary,
        topBar = {
            HomeTopBar(
                navController
            ) {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }
                 },
        drawerContent = {
            Drawer (name = viewModel.name, email = viewModel.email){
                coroutineScope.launch {
                    viewModel.onLogout()
                    delay(250)
                    scaffoldState.drawerState.close()
                }
            }
        }
    ) {
        HomeContent(navController = navController, paddingValues = it)
    }

    if (viewModel.signout){
        LaunchedEffect(key1 = Unit ){
            navController.popBackStack()
            navController.navigate(Screen.Login.route)
        }
    }
}

@Composable
fun Drawer(
    gradientColors: List<Color> = listOf(colorPrimary, colorSecondary),
    name: String,
    email:String,
    onClick: () -> Unit,
) {
    val navigationDrawerItems = listOf(
        NavigationDrawerItem.Payments,
        NavigationDrawerItem.Settings,
        NavigationDrawerItem.Logout
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = gradientColors))
            .padding(24.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            model = ImageRequest
                .Builder(LocalContext.current)
                .data("musicImage")
                .crossfade(1000)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_circular_placeholder),
            error = painterResource(id = R.drawable.ic_circular_placeholder),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = name,
            fontStyle = MaterialTheme.typography.subtitle1.fontStyle,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            color = Color.White
        )
        Text(
            text = email,
            fontStyle = MaterialTheme.typography.subtitle2.fontStyle,
            fontSize = MaterialTheme.typography.subtitle2.fontSize,
            color = Color.LightGray.copy(alpha = 0.5f)
        )
        Divider(modifier = Modifier.padding(top = 10.dp),color = Color.White, thickness = 1.dp)
        NavigationListItem(
            navigationDrawerItems[0]
        ) {
            onClick()
        }
        NavigationListItem(
            navigationDrawerItems[1]
        ) {
            onClick()
        }
        NavigationListItem(
            navigationDrawerItems[2]
        ) {
            //TODO Logout Session
            onClick()
        }
    }
}

@Composable
private fun NavigationListItem(
    item: NavigationDrawerItem,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = "Navigation Drawer Item Icon"
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.label,
            fontSize = MaterialTheme.typography.subtitle2.fontSize,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(paddingValues = PaddingValues(), navController = rememberNavController())
}

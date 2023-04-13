package com.example.musictime.login

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.core.Graph
import com.example.musictime.core.Screen
import com.example.musictime.theme.colorPrimary
import com.example.theme.R

@Composable
fun LoginScreen(
    rootNavController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .background(colorPrimary)
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Login(Modifier.align(Alignment.TopStart), viewModel, rootNavController)
        VersionEnd(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, rootNavController: NavHostController) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnabled: Boolean by viewModel.loginEnabled.observeAsState(initial = false)
    val loginSuccess: Int by viewModel.loginSuccess.observeAsState(initial = -1)
    val showProgress: Boolean by viewModel.showProgress.observeAsState(initial = false)

    /*
    if (loginSuccess) {
        LaunchedEffect(key1 = loginSuccess) {
            rootNavController.popBackStack()
            rootNavController.navigate(Graph.BOTTOM)
        }
    }

     */

    when(loginSuccess){
        0-> {
            LaunchedEffect(key1 = loginSuccess) {
                rootNavController.popBackStack()
                rootNavController.navigate(Graph.BOTTOM)
            }
        }
        1-> {
            val context = LocalContext.current
            //Toast.makeText(context,"Not Register",Toast.LENGTH_LONG).show()
        }
    }

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        EmailField(email) { viewModel.onLoginChanged(it, password) }
        PasswordField(password) { viewModel.onLoginChanged(email, it) }
        ForgotPasswordButton(Modifier.align(Alignment.End))
        LoginButton(loginEnabled, viewModel)
        ShowProgressBar(showProgress, Modifier.align(Alignment.CenterHorizontally))
        SignUpButton(Modifier.align(Alignment.CenterHorizontally), rootNavController)
    }
}

@Composable
fun ShowProgressBar(showProgress: Boolean, modifier: Modifier) {
    if(showProgress){
        Column(
            modifier = modifier,
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(size = 16.dp),
                color = Color(0xFFFED0D2)
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
fun LoginButton(
    loginEnabled: Boolean,
    viewModel: LoginViewModel
) {
    Button(
        onClick = { viewModel.requestLogin() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFC8F0D6),
            disabledBackgroundColor = Color(0x8BC8F0D6),
            contentColor = Color(0xFF222838),
            disabledContentColor = Color(0xFF222838)
        ),
        enabled = loginEnabled
    ) {
        Text(text = "Login")
    }
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun VersionEnd(modifier: Modifier) {
    Text(
        text = "©LT",
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun SignUpButton(modifier: Modifier, rootNavController: NavHostController
) {
    Text(
        text = "Sign up",
        modifier = modifier.clickable { rootNavController.navigate(Screen.SignUp.route) },
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun ForgotPasswordButton(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        modifier = modifier.clickable { },
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    Spacer(modifier = Modifier.padding(16.dp))
}

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Email", color = Color(0xFF222838)) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF4E5C81),
            backgroundColor = Color.White,
            focusedIndicatorColor = Color(0xFFFED0D2),
            unfocusedIndicatorColor = Color(0xFFC8F0D6)
        ),
    )
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Password", color = Color(0xFF222838)) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF4E5C81),
            backgroundColor = Color.White,
            focusedIndicatorColor = Color(0xFFFED0D2),
            unfocusedIndicatorColor = Color(0xFFC8F0D6)
        )
    )
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Header",
        modifier = modifier
            .fillMaxWidth()
            .width(150.dp)
            .height(150.dp),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() { LoginScreen(rootNavController = rememberNavController()) }
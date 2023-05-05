package com.example.musictime.presentation.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.musictime.login.*
import com.example.musictime.theme.colorPrimary
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.musictime.core.Graph
import com.example.musictime.core.Screen
import com.example.theme.R

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
    val name: String by viewModel.name.observeAsState(initial = "")
    val emailSignUp: String by viewModel.emailSignUp.observeAsState(initial = "")
    val passwordSignUp: String by viewModel.passwordSignUp.observeAsState(initial = "")
    val signUpEnabled: Boolean by viewModel.signUpEnabled.observeAsState(initial = false)
    val showProgress: Boolean by viewModel.showProgress.observeAsState(initial = false)
    val signUpSuccess: Boolean by viewModel.signupSuccess.observeAsState(initial = false)

    if (signUpSuccess) {

        LaunchedEffect(key1 = signUpSuccess) {
            rootNavController.popBackStack()
         //   rootNavController.navigate(Graph.BOTTOM)
        }
       // rootNavController.navigate(Screen.Login.route)
    }

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        NameField(name) { viewModel.onSignUpChanged(it, emailSignUp, passwordSignUp) }
        EmailFieldSignUp(emailSignUp) { viewModel.onSignUpChanged(name, it, passwordSignUp) }
        PasswordFieldSignUp(passwordSignUp) { viewModel.onSignUpChanged(name, emailSignUp, it) }
        SignUpRegisterButton(signUpEnabled,viewModel)
        ShowProgressBar(showProgress, Modifier.align(Alignment.CenterHorizontally))
        LoginBackButton( Modifier.align(Alignment.CenterHorizontally), rootNavController)


        /*
        Text(
            text = "Epa",
            modifier = modifier.clickable { rootNavController.popBackStack() },
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

         */
    }
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

@Composable
fun NameField(name: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Name", color = Color(0xFF222838)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
fun EmailFieldSignUp(email: String, onTextFieldChanged: (String) -> Unit) {
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
fun PasswordFieldSignUp(password: String, onTextFieldChanged: (String) -> Unit
) {
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
fun SignUpRegisterButton(signUpEnabled: Boolean, viewModel: SignUpViewModel) {
    Button(
        onClick = { viewModel.requestSignUp() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFC8F0D6),
            disabledBackgroundColor = Color(0x8BC8F0D6),
            contentColor = Color(0xFF222838),
            disabledContentColor = Color(0xFF222838)
        ),
        enabled = signUpEnabled
    ) {
        Text(text = "Sign Up")
    }

    Spacer(modifier = Modifier.padding(10.dp))
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
        }
    }
}

@Composable
fun LoginBackButton(modifier: Modifier, rootNavController: NavHostController) {
    Text(
        text = "Login",
        modifier = modifier.clickable {  rootNavController.navigate(Screen.Login.route) },
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() { SignUpScreen(rootNavController = rememberNavController()) }
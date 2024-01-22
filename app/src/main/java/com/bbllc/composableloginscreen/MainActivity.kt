package com.bbllc.composableloginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bbllc.composableloginscreen.ui.theme.ComposableLoginScreenTheme
import com.bbllc.composableloginscreen.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableLoginScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {

    /*Using Viewmodel and MutableFlow*/
    val loginViewModel: LoginViewModel = viewModel()
    val userName by loginViewModel.userNameState.collectAsState()


    /*Using State Variable to save the state*/
    var password by rememberSaveable { mutableStateOf("") }

    Column {
        OutlinedTextField(value = userName,
            onValueChange = { loginViewModel.updateUserName(it)},
            label = { Text(text = "User Name") }
        )

        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") }
        )


        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableLoginScreenTheme {}
}
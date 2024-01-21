package com.bbllc.composableloginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bbllc.composableloginscreen.ui.theme.ComposableLoginScreenTheme
import com.bbllc.composableloginscreen.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {

    val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableLoginScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen("Android")
                }
            }
        }
    }
}

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {

    var userName by rememberSaveable { mutableStateOf("") }

    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        OutlinedTextField(value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "User Name") }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableLoginScreenTheme {
        LoginScreen("Android")
    }
}
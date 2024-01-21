package com.bbllc.composableloginscreen.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update


data class Login(val userName: String = "", val password: String = "")


class LoginViewModel : ViewModel() {


    private val _loginState = MutableStateFlow(Login())
    val loginState = _loginState


    fun updateLoginCredentials(userName: String, password: String) {

        _loginState.update { currentState ->
            currentState.copy(
                userName = userName,
                password = password
            )
        }

    }

}
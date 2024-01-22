package com.bbllc.composableloginscreen.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


data class Login(val userName: String = "", val password: String = "")


class LoginViewModel : ViewModel() {


    private val _userNameState = MutableStateFlow<String>("")
    val userNameState: StateFlow<String> = _userNameState


    fun updateUserName(userName: String) {
        _userNameState.value = userName
    }

}
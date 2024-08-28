package com.playground.fttc.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Ready)
    var uiState = _uiState.asStateFlow()

    fun ready() {
        _uiState.value = LoginUiState.Ready
    }

    fun login(userId: String, password: String) {
        Log.d("LoginViewModel", "Login($userId, $password)")

        viewModelScope.launch {
            if (userId.isEmpty()) {
                _uiState.value = LoginUiState.Error.EmptyUserIdError
            } else if (password.isEmpty()) {
                _uiState.value = LoginUiState.Error.EmptyPasswordError
            } else if (userId != password) {
                _uiState.value = LoginUiState.Error.NotMatchedError
            } else {
                _uiState.value = LoginUiState.Success
            }
        }
    }
}
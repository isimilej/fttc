package com.playground.fttc.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.playground.fttc.domain.user.LoginResult
import com.playground.fttc.domain.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Ready)
    var uiState = _uiState.asStateFlow()

    fun ready() {
        _uiState.value = LoginUiState.Ready
    }

    fun login(userId: String, password: String) {
        Log.d("LoginViewModel", "Login($userId, $password)")

        viewModelScope.launch {
            if (userId.isEmpty()) {
                _uiState.value = LoginUiState.Error.EmptyUserId
            } else if (password.isEmpty()) {
                _uiState.value = LoginUiState.Error.EmptyPassword
            } else {
                when (val result = repository.login(userId, password)) {
                    is LoginResult.Success -> {
                        _uiState.value = LoginUiState.Success
                    }
                    is LoginResult.Fail -> {
                        when (result) {
                            is LoginResult.Fail.NotFoundUser -> {
                                _uiState.value = LoginUiState.Error.NotFoundUser
                            }
                            is LoginResult.Fail.NotMatched -> {
                                _uiState.value = LoginUiState.Error.NotMatched
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Factory for LoginViewModel that takes PostsRepository as a dependency
     */
    companion object {
        fun provideFactory(
            repository: UserRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginViewModel(repository) as T
            }
        }
    }

}
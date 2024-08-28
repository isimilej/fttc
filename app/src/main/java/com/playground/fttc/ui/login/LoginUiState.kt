package com.playground.fttc.ui.login

sealed interface LoginUiState {
    data object Ready: LoginUiState
    data object Loading : LoginUiState
    data object Success: LoginUiState
    sealed interface Error: LoginUiState {
        data object EmptyUserIdError: Error
        data object EmptyPasswordError: Error
        data object NotMatchedError: Error
    }
}
package com.playground.fttc.ui.login

sealed class LoginUiState {
    data object Ready : LoginUiState()
    data object Loading : LoginUiState()
    data object Success : LoginUiState()

    sealed class Error : LoginUiState() {
        data object EmptyUserId : Error()
        data object EmptyPassword : Error()
        data object NotFoundUser : Error()
        data object NotMatched : Error()
    }

}
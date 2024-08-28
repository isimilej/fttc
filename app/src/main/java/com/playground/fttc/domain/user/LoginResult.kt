package com.playground.fttc.domain.user

sealed class LoginResult {
    data class Success(val user: User): LoginResult()
    sealed class Fail: LoginResult() {
        data object NotFoundUser : Fail()
        data object NotMatched: Fail()
    }
}
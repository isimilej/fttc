package com.playground.fttc.domain.user

interface UserRepository {
    fun login(userId: String, password: String): LoginResult
}
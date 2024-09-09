package com.playground.fttc.di

import android.content.Context
import com.playground.fttc.data.user.FakeUserRepository
import com.playground.fttc.domain.user.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {
    override val userRepository: UserRepository by lazy {
        FakeUserRepository()
    }
}
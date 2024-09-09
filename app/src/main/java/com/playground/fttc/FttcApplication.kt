package com.playground.fttc

import android.app.Application
import com.playground.fttc.di.AppContainer
import com.playground.fttc.di.AppContainerImpl

class FttcApplication : Application() {

    // AppContainer instance used by the rest of classes to obtain dependencies
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}
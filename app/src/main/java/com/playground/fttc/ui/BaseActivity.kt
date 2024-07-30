package com.playground.fttc.ui

import android.content.Intent
import androidx.activity.ComponentActivity
import com.playground.fttc.ui.home.HomeActivity
import com.playground.fttc.ui.login.LoginActivity

abstract class BaseActivity : ComponentActivity() {

    protected fun goLogin() {
        startActivity(Intent(this, LoginActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        })
    }

    protected fun goHome() {
        startActivity(Intent(this, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        })
    }
}
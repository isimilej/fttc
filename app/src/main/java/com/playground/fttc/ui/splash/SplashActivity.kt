package com.playground.fttc.ui.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.playground.fttc.ui.BaseActivity
import com.playground.fttc.ui.theme.FTTCTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FTTCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    initLayout()
                }
            }
        }

        lifecycleScope.launch {
            delay(1_000)
            goLogin()
        }
    }

    @Composable
    private fun initLayout() {
        Text(
            text = "Splash..."
        )
    }
}
package com.playground.fttc.ui.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.playground.fttc.R
import com.playground.fttc.ui.BaseActivity
import com.playground.fttc.ui.theme.FTTCTheme
import kotlinx.coroutines.delay

class IntroActivity : BaseActivity() {
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
    }

    @Composable
    private fun initLayout() {
        val comp by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.loading)
        )

        val stateProgress = animateLottieCompositionAsState(composition = comp, iterations = LottieConstants.IterateForever)

        LottieAnimation(
            composition = comp,
            progress = stateProgress.value,
            contentScale = ContentScale.FillHeight
        )

        LaunchedEffect(true) {
            delay(3_000)
            goLogin()
        }
    }
}
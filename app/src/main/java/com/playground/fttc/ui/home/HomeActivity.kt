package com.playground.fttc.ui.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val b: androidx.compose.material3.windowsizeclass.WindowWidthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            Log.d("FTTC", "$b")
            //WindowWidthSizeClass.Expanded
            //WindowWidthSizeClass.Medium
            //WindowWidthSizeClass.Compact

            //widthSizeClass: WindowWidthSizeClass
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            val isExpandedScreen = widthSizeClass == WindowWidthSizeClass.Expanded

            FttcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = FttcStyle.color.Background
                ) {
                    HomeScreen(isExpandedScreen)
                }
            }
        }
    }
}



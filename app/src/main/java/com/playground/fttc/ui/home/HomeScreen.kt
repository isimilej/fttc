package com.playground.fttc.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.playground.fttc.ui.theme.FttcStyle

@Composable
fun HomeScreen(widthSizeClass: WindowWidthSizeClass, isExpandedScreen: Boolean) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (header, content, footer) = createRefs()
        Row(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(header) {
                top.linkTo(parent.top)
            },
        ) {
            HomeHeader()
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .constrainAs(content) {
                top.linkTo(header.bottom)
            }
        ) {
            when (widthSizeClass) {
                WindowWidthSizeClass.Expanded -> ExpandedHomeContent()
                WindowWidthSizeClass.Medium -> MediumHomeContent()
                else -> CompactHomeContent()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PHONE)
@Composable
fun PreviewCompactHomeScreen() {
    HomeScreen(WindowWidthSizeClass.Compact, false)
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.FOLDABLE)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(WindowWidthSizeClass.Medium, false)
}

@Preview("Home Expanded", showSystemUi = true, showBackground = true, device = Devices.TABLET)
@Composable
fun PreviewExpandedHomeScreen() {
    HomeScreen(WindowWidthSizeClass.Expanded, true)
}
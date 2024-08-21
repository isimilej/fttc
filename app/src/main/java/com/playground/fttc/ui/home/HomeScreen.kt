package com.playground.fttc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcStyle

@Composable
fun HomeContentExpanded() {
    val detailLazyListStates = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = detailLazyListStates
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HomeSearchCard()
                Column {
                    HomeLocationCard()
                    HomeDocumentCard(10)
                    HomeSendCard()
                }
            }
        }
    }
}

@Composable
fun HomeMediumScreen() {
    val detailLazyListStates = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = detailLazyListStates
    ) {
        item {
            HomeSearchCard()
        }
        item {
            Row {
                HomeLocationCard()
                HomeDocumentCard(5)
            }
        }
    }
}

@Composable
fun HomeContent() {
    val detailLazyListStates = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = detailLazyListStates
    ) {
        item {
            HomeSearchCard()
        }
        item {
            HomeLocationCard()
        }
        item {
            HomeDocumentCard(10)
        }
    }
}

@Composable
fun HomeScreen(isExpandedScreen: Boolean) {
    Column(
        modifier = Modifier.background(FttcStyle.color.Background)
    ) {
        Header()
        if (isExpandedScreen)
            HomeContentExpanded()
        else
            HomeContent()
    }
}

@Composable
private fun Header() {
    HomeHeader()
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(62.dp)
//            .background(FttcStyle.color.Blue50),
//    ) {
//        Text("박기업 차장")
//    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PHONE)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(false)
}

@Preview("Home Expanded", showSystemUi = true, showBackground = true, device = "spec:width=800dp,height=1280dp,dpi=320")
@Composable
fun PreviewMediumHomeScreen() {
    HomeMediumScreen()
    //HomeScreen(false)
}

@Preview("Home Expanded", showSystemUi = true, showBackground = true, device = Devices.TABLET)
@Composable
fun PreviewExpandedHomeScreen() {
    HomeScreen(true)
}
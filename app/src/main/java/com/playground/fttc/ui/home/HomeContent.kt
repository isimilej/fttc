package com.playground.fttc.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExpandedHomeContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Row(
            Modifier.fillMaxWidth(0.9f).height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            HomeSearchCard(modifier = Modifier.weight(1.74f))
            Spacer(Modifier.width(24.dp))
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HomeSuperMapCard(modifier = Modifier.fillMaxWidth())
                HomeDocumentCard(10, modifier = Modifier.fillMaxWidth())
                HomeSendCard(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun MediumHomeContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            HomeSearchCard(modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(16.dp))
            Row {
                HomeSuperMapCard(modifier = Modifier.weight(1f))
                Spacer(Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    HomeDocumentCard(10, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                    HomeSendCard(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun CompactHomeContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            HomeSearchCard(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            HomeSuperMapCard(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            HomeDocumentCard(11, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            HomeSendCard(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview(device = Devices.PHONE)
@Composable
fun PreviewCompactHomeContent() {
    CompactHomeContent()
}

@Preview(device = Devices.FOLDABLE)
@Composable
fun PreviewMediumHomeContent() {
    MediumHomeContent()
}

@Preview(device = Devices.TABLET)
@Composable
fun PreviewExpandedHomeContent() {
    ExpandedHomeContent()
}


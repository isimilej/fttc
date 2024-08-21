package com.playground.fttc.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ExpandedHomeContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (searchRef, spaceRef, superMapRef, documentRef, sendRef, bottomSpaceRef) = createRefs()
            HomeSearchCard(Modifier.constrainAs(searchRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, 24.dp)
                end.linkTo(superMapRef.start)
            })
            Spacer(modifier = Modifier
                .constrainAs(spaceRef) {
                    start.linkTo(searchRef.end)
                    top.linkTo(searchRef.top)
                }
                .width(24.dp))

            HomeSuperMapCard(Modifier.constrainAs(superMapRef) {
                start.linkTo(spaceRef.end)
                top.linkTo(parent.top, 24.dp)
                end.linkTo(parent.end)
            })
            HomeDocumentCard(10, modifier = Modifier.constrainAs(documentRef) {
                start.linkTo(superMapRef.start)
                top.linkTo(superMapRef.bottom, 16.dp)
            })
            HomeSendCard(modifier = Modifier.constrainAs(sendRef) {
                start.linkTo(superMapRef.start)
                top.linkTo(documentRef.bottom, 16.dp)
            })
            createHorizontalChain(searchRef, spaceRef, superMapRef, chainStyle = ChainStyle.Packed)
            Spacer(modifier = Modifier
                .constrainAs(bottomSpaceRef) {
                    start.linkTo(parent.start)
                    top.linkTo(searchRef.bottom)
                    end.linkTo(parent.end)
                }
                .height(156.dp))
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
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (searchRef, spaceRef, superMapRef, documentRef, sendRef, bottomSpaceRef) = createRefs()
            HomeSearchCard(Modifier.constrainAs(searchRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, 24.dp)
                end.linkTo(parent.end)
            })
            HomeSuperMapCard(Modifier.constrainAs(superMapRef) {
                start.linkTo(parent.start)
                top.linkTo(searchRef.bottom, 16.dp)
                end.linkTo(documentRef.start)
            })
            HomeDocumentCard(10, modifier = Modifier.constrainAs(documentRef) {
                start.linkTo(superMapRef.end)
                top.linkTo(superMapRef.top)
            })
            HomeSendCard(modifier = Modifier.constrainAs(sendRef) {
                start.linkTo(documentRef.start)
                top.linkTo(documentRef.bottom, 16.dp)
            })
//            createHorizontalChain(searchRef, spaceRef, superMapRef, chainStyle = ChainStyle.Packed)
//            Spacer(modifier = Modifier
//                .constrainAs(bottomSpaceRef) {
//                    start.linkTo(parent.start)
//                    top.linkTo(searchRef.bottom)
//                    end.linkTo(parent.end)
//                }.height(156.dp))
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
    ) {
        HomeSearchCard()
        Spacer(modifier = Modifier.height(16.dp))
        HomeSuperMapCard()
        Spacer(modifier = Modifier.height(16.dp))
        HomeDocumentCard(11)
        Spacer(modifier = Modifier.height(16.dp))
        HomeSendCard()
        // TODO: SoftNavigator Keypad
        Spacer(modifier = Modifier.height(52.dp))
    }
}

@Preview(device = Devices.PHONE)
@Composable
fun PreviewCompactHomeContent() {
    CompactHomeContent()
}

//@Preview(device = Devices.FOLDABLE)
@Composable
fun PreviewMediumHomeContent() {
    MediumHomeContent()
}

//@Preview(device = Devices.TABLET)
@Composable
fun PreviewExpandedHomeContent() {
    ExpandedHomeContent()
}


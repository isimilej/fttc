package com.playground.fttc.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.ui.theme.FttcStyle


@Composable
fun HomeContent() {
    Row {
        Card(
            modifier = Modifier.size(width = 696.dp, height = 500.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = FttcStyle.color.Blue100
            ),
            elevation = CardDefaults.outlinedCardElevation(
                defaultElevation = 16.dp
            )
        ) {
            Text(text = "1111111")
        }
        Column {
            Card(
                modifier = Modifier.size(width = 400.dp, height = 424.dp),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = FttcStyle.color.Blue400
                ),
                elevation = CardDefaults.outlinedCardElevation(
                    defaultElevation = 16.dp
                )
            ) {
                Text(text = "222222")
            }
            Card(
                modifier = Modifier.size(width = 400.dp, height = 104.dp),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = FttcStyle.color.Blue800
                ),
                elevation = CardDefaults.outlinedCardElevation(
                    defaultElevation = 16.dp
                )
            ) {
                Text(text = "333333")
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.background(FttcStyle.color.Background)
    ) {
        Header()
        HomeContent()
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .background(FttcStyle.color.Blue50),
    ) {
        Text("박기업 차장")
    }
}

//@Preview(showSystemUi = true, showBackground = true, device = Devices.PHONE)
//@Composable
//fun PreviewHomeScreen() {
//    HomeScreen()
//}

@Preview(showSystemUi = true, showBackground = true, device = Devices.TABLET)
@Composable
fun PreviewTabletHomeScreen() {
    HomeScreen()
}
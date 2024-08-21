package com.playground.fttc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .padding(horizontal = 80.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        HomeHeaderUserLayout()
        HomeHeaderMenuLayout()
    }
}

@Composable
private fun HomeHeaderUserLayout() {
    Row {
        HomeHeaderHomeCard()
        Spacer(modifier = Modifier.width(24.dp))
        Column {
            Text(
                text = "박기업 차장",
                style = FttcStyle.typo.T3Bold
            )
            Text(
                text = "강동강북여신심사센터",
                style = FttcStyle.typo.B3SemiBold.copy(color = FttcStyle.color.Grey500)
            )
        }
    }
}

@Composable
private fun HomeHeaderHomeCard() {
    Card(
        modifier = Modifier.size(48.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.White
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(
            modifier = Modifier.size(48.dp),
        ) {
            Image(
                painterResource(id = R.drawable.ic_home),
                null,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Center)
            )
        }
    }
}


@Composable
private fun HomeHeaderMenuLayout() {
    Row {
        Image(
            painterResource(id = R.drawable.ic_logout),
            null,
            modifier = Modifier.size(48.dp)
        )
        Image(
            painterResource(id = R.drawable.ic_alarm_on),
            null,
            modifier = Modifier.size(48.dp)
        )
        Image(
            painterResource(id = R.drawable.ic_calendar),
            null,
            modifier = Modifier.size(48.dp)
        )
        Image(
            painterResource(id = R.drawable.ic_menu),
            null,
            modifier = Modifier.size(48.dp)
        )
    }
}

//@Preview(widthDp = 480)
//@Composable
//fun PreviewHomeHeader() {
//    FttcTheme {
//        HomeHeader()
//    }
//}
//
//@Preview(widthDp = 640)
//@Composable
//fun PreviewHomeHeader() {
//    FttcTheme {
//        HomeHeader()
//    }
//}

@Preview
@Composable
fun PreviewHomeHeaderHomeCard() {
    HomeHeaderHomeCard()
}

@Preview(widthDp = 840)
@Composable
fun PreviewHomeHeader() {
    FttcTheme {
        HomeHeader()
    }
}




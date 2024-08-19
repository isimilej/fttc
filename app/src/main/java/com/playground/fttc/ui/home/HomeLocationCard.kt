package com.playground.fttc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@Composable
fun HomeLocationCard() {
    Card(
        modifier = Modifier.width(400.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.White
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "신규고객 찾기 슈퍼맵",
                style = FttcStyle.typo.T4SemiBold.copy(brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF1983FF), Color(0xFF6F2BFF))
                )),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "지도에서 내주변\n신규 기업고객을 찾아보세요",
                style = FttcStyle.typo.T1SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "바로가기")
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.home_map_marker),
                null,
                modifier = Modifier.size(width = 320.dp, height = 180.dp)
            )
        }
    }
}

@Preview("Home SuperMap Card")
@Composable
fun PreviewHomeSuperMapCard() {
    FttcTheme {
        Surface {
            HomeLocationCard()
        }
    }
}
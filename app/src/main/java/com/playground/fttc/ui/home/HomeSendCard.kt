package com.playground.fttc.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@Composable
fun HomeSendCard() {
    Card(
        modifier = Modifier.width(420.dp).height(56.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.White
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "IBK 사이트 URL 발송",
                modifier = Modifier.weight(1f),
                style = FttcStyle.typo.T4SemiBold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "인감지 파일 발송",
                modifier = Modifier.weight(1f),
                style = FttcStyle.typo.T4SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeSendCard() {
    FttcTheme {
        Surface {
            HomeSendCard()
        }
    }
}
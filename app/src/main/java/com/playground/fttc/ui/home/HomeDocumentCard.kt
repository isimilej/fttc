package com.playground.fttc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@Composable
fun HomeDocumentCard(count: Int) {
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
        Row(
            modifier = Modifier
                .padding(start = 40.dp, top = 32.dp, end = 32.dp, bottom = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.extension_of_period_customer),
                    style = FttcStyle.typo.T2SemiBold
                )
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = count.toString(),
                        style = FttcStyle.typo.Base.copy(
                            color = FttcStyle.color.Blue600,
                            fontSize = 40.sp,
                            lineHeight = 52.sp,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.count),
                        modifier = Modifier.padding(start = 6.dp, bottom = 4.dp),
                        style = FttcStyle.typo.B1.copy(color = FttcStyle.color.Grey600)
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_home_document),
                contentDescription = null,
                modifier = Modifier.size(width = 136.dp, height = 108.dp)
            )
        }
    }
}

@Preview("Home Document Card")
@Composable
fun PreviewHomeDocumentCard() {
    FttcTheme {
        Surface {
            HomeDocumentCard(11)
        }
    }
}
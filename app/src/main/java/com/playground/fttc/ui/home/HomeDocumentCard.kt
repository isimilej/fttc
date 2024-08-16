package com.playground.fttc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcStyle

@Composable
fun HomeDocumentCard() {
    Card(
        modifier = Modifier.width(400.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.Blue800
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Text(text = "333333")
        Image(
            painter = painterResource(id = R.drawable.ic_home_document),
            null
        )
    }
}

@Preview("Home Document Card")
@Composable
fun PreviewHomeDocumentCard() {
    HomeDocumentCard()
}
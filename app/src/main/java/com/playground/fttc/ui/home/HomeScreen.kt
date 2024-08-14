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
                HomeMainCard()
                Column {
                    HomeMapCard()
                    HomeDocumentCard()
                }
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
            HomeMainCard()
        }
        item {
            HomeMapCard()
        }
        item {
            HomeDocumentCard()
        }
    }
}

@Composable
private fun HomeMainCard() {
    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.Blue100
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Text(
            text = "신규 고객 발굴부터 기존 기업고객 상담을 위해",
            style = FttcStyle.typo.B1SemiBold.copy(color = FttcStyle.color.Grey500)
        )
        Text(
            text = "기업정보를 쉽고 빠르게 검색해보세요",
            style = FttcStyle.typo.H2Bold
        )
        Text(
            text = "기업명을 입력해 주세요",
        )
        Text(
            text = "3월 경영평가 1등 지점에서 가장 많이 쓴 메뉴 TOP3!"
        )
        LazyRow {
            item {
                Image(
                    painter = painterResource(id = R.drawable.home_top3_first_bg),
                    null
                )
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.home_top3_second_bg),
                    null
                )
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.home_top3_third_bg),
                    null
                )
            }
        }
        Text(
            text = "마이메뉴"
        )
        Text(
            text = "고객정보 등록/변경 고객확인의무(CDD/EDD) 상품추천 펀드 신규가입 금리인하"
        )
    }
}

@Composable
private fun HomeDocumentCard() {
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

@Composable
private fun HomeMapCard() {
    Card(
        modifier = Modifier.width(400.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.Blue400
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Text(text = "신규고객 찾기 슈퍼맵")
        Text(text = "지도에서 내주변")
        Text(text = "신규고객 찾기 슈퍼맵")
        Text(text = "바로가기")
        Image(
            painter = painterResource(id = R.drawable.home_map_marker),
            null
        )
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
//    HomeScreen(false)
//}

@Preview("Home Expanded", showSystemUi = true, showBackground = true, device = Devices.TABLET)
@Composable
fun PreviewExpandedHomeScreen() {
    HomeScreen(true)
}
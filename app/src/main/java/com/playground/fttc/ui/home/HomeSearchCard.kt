package com.playground.fttc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
fun HomeSearchCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(632.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.White
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 48.dp, end = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "신규 고객 발굴부터 기존 기업고객 상담을 위해",
                style = FttcStyle.typo.B1SemiBold.copy(color = FttcStyle.color.Grey500)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "기업정보를 쉽고 빠르게 검색해보세요",
                style = FttcStyle.typo.H2Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            SearchInput()
            Spacer(modifier = Modifier.height(64.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "3월 경영평가 1등 지점에서 가장 많이 쓴 메뉴 ",
                    style = FttcStyle.typo.T2SemiBold
                )
                Text(
                    text = "TOP3!",
                    style = FttcStyle.typo.H2Bold.copy(color = FttcStyle.color.Blue600)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_top3_first_bg),
                    null,
                    modifier = Modifier.size(width = 192.dp, height = 148.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.home_top3_second_bg),
                    null,
                    modifier = Modifier.size(width = 192.dp, height = 148.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.home_top3_third_bg),
                    null,
                    modifier = Modifier.size(width = 192.dp, height = 148.dp)
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "마이메뉴",
                modifier = Modifier.fillMaxWidth(),
                style = FttcStyle.typo.T2Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "고객정보 등록/변경 | 고객확인의무(CDD/EDD) | 상품추천 | 펀드 신규가입 | 금리인하",
                modifier = Modifier.fillMaxWidth(),
                style = FttcStyle.typo.B2
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview("Home Search Card", widthDp = 696)
@Composable
fun PreviewHomeSearchCard() {
    FttcTheme {
        Surface {
            HomeSearchCard()
        }
    }
}

@Composable
fun SearchInput() {
    Card(
        modifier = Modifier.width(420.dp).height(56.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = FttcStyle.color.White
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "기업명을 입력해 주세요",
                style = FttcStyle.typo.B1.copy(color = FttcStyle.color.Grey300)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSearchInput() {
    FttcTheme {
        Surface {
            SearchInput()
        }
    }
}
package com.playground.fttc.ui.login

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.component.InputField
import com.playground.fttc.ui.component.PrimaryButton
import com.playground.fttc.ui.home.HomeActivity
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@Composable
fun HomeScreen() {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FttcStyle.color.Background),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = FttcStyle.color.White
            ),
            elevation = CardDefaults.outlinedCardElevation(
                defaultElevation = 16.dp
            ),
        ) {
            Column(
                modifier = Modifier
                    .width(490.dp)
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Login", style = FttcStyle.typo.H1Bold)
                Spacer(Modifier.height(24.dp))
                LoginTypeTabRow(listOf("MOTP 입력", "생체인증(FIDO)"))
                Spacer(Modifier.height(24.dp))
                InputField(
                    value = "id,",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))
                InputField(
                    value = "password,",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(48.dp))
                PrimaryButton(
                    onClick = {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    },
                    text = stringResource(id = R.string.login),
                    modifier = Modifier.size(width = 400.dp, height = 56.dp))
            }
        }
    }

}

@Composable
private fun LoginTypeTabRow(tabList: List<String>) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        containerColor = Color.Transparent,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    height = 2.dp,
                    color = FttcStyle.color.Brand
                )
            }
        }
    ) {
        tabList.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                modifier = Modifier.height(48.dp)
            ) {
                Text(
                    text = tab,
                    style = FttcStyle.typo.T3SemiBold.copy(
                        color = if (selectedTabIndex == index) FttcStyle.color.Brand else FttcStyle.color.Grey600
                    )
                )
            }
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
fun PreviewExpandedHomeContent() {
    FttcTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen()
        }
    }
}

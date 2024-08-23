package com.playground.fttc.ui.login

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
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
            modifier = Modifier.padding(40.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = FttcStyle.color.White
            ),
            elevation = CardDefaults.outlinedCardElevation(
                defaultElevation = 16.dp
            ),
        ) {
            Column(
                modifier = Modifier.width(IntrinsicSize.Max).padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    style = FttcStyle.typo.H1Bold
                )
                Spacer(Modifier.height(96.dp))
                TextField(
                    value = "id,",
                    onValueChange = {},
                    modifier = Modifier.width(400.dp),
                    singleLine = true)
                TextField(value = "password,", onValueChange = {

                })
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

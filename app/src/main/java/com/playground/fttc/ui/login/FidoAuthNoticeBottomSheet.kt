package com.playground.fttc.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.component.PopupPrimaryFttcButton
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FidoAuthNoticeBottomSheet() {
    ModalBottomSheet(
        onDismissRequest = {},
        containerColor = FttcStyle.color.White,
        dragHandle = null,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_phone_fido),
                contentDescription = null,
                modifier = Modifier.size(width = 160.dp, height = 128.dp)
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "생체인증(FIDO)을 진행해 주세요.",
                style = FttcStyle.typo.B2.copy(color = FttcStyle.color.Grey600)
            )
            Spacer(Modifier.height(32.dp))
            PopupPrimaryFttcButton(
                text = "인증 재요청",
                onClick = { /*TODO*/ },
                modifier = Modifier.width(160.dp)
            )
            Spacer(Modifier.height(40.dp))
        }
    }
}

@Preview(name = "Portrait Mode", showBackground = true, device = Devices.PHONE)
@Composable
fun FidoBottom() {
    FttcTheme {
        Surface {
            FidoAuthNoticeBottomSheet()
        }
    }
}

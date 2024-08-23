package com.playground.fttc.ui.component

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcColor
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTypo

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (pressed) FttcStyle.color.Blue700 else FttcStyle.color.Primary,
            disabledContainerColor = FttcStyle.color.Grey100
        ),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = FttcStyle.typo.T2SemiBold,
            color = if (enabled) FttcStyle.color.White else FttcStyle.color.Grey300
        )
    }
}

@Preview("PrimaryButton", widthDp = 360, heightDp = 64)
@Composable
fun PreviewPrimaryButton() {
    Box(contentAlignment = Alignment.Center) {
        PrimaryButton(
            onClick = {},
            text = stringResource(id = R.string.login),
            modifier = Modifier.size(width = 320.dp, height = 56.dp),
            enabled = true
        )
    }
}

@Preview("Disabled PrimaryButton", widthDp = 360, heightDp = 64)
@Composable
fun PreviewDisabledPrimaryButton() {
    Box(contentAlignment = Alignment.Center) {
        PrimaryButton(
            onClick = {},
            text = stringResource(id = R.string.login),
            modifier = Modifier.size(width = 320.dp, height = 56.dp),
            enabled = false
        )
    }
}

@Composable
fun PrimaryMediumButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    Log.d("Fttc", "Pressed=$pressed")
    Button(
        onClick = {},
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (pressed) FttcStyle.color.Blue700 else FttcStyle.color.Primary,
            disabledContainerColor = FttcStyle.color.Grey100
        ),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = FttcStyle.typo.T4SemiBold,
            color = if (enabled) FttcStyle.color.White else FttcStyle.color.Grey300
        )
    }
}

@Preview("Medium PrimaryButton", widthDp = 360, heightDp = 64)
@Composable
fun PreviewPrimaryMediumButton() {
    Box(contentAlignment = Alignment.Center) {
        PrimaryMediumButton(
            stringResource(id = R.string.login),
            Modifier.size(width = 320.dp, height = 48.dp),
        )
    }
}


@Composable
fun PrimarySmallButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    Log.d("Fttc", "Pressed=$pressed")
    Button(
        onClick = {},
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (pressed) FttcStyle.color.Blue900 else FttcStyle.color.Blue800,
            disabledContainerColor = FttcStyle.color.Grey100
        ),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = FttcStyle.typo.T4SemiBold,
            color = if (enabled) FttcStyle.color.White else FttcStyle.color.Grey300
        )
    }
}

@Preview("Small PrimaryButton", widthDp = 360, heightDp = 64)
@Composable
fun PreviewPrimarySmallButton() {
    Box(contentAlignment = Alignment.Center) {
        PrimarySmallButton(
            stringResource(id = R.string.login),
            Modifier.size(width = 320.dp, height = 48.dp),
        )
    }
}

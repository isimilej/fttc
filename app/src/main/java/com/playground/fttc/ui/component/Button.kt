package com.playground.fttc.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.playground.fttc.ui.theme.FttcStyle

data class FttcButtonColors(
    val enabledContentColor: Color,
    val disabledContentColor: Color,
    val enabledContainerColor: Color,
    val pressedContainerColor: Color,
    val disabledContainerColor: Color,
) {
    fun contentColor(enabled: Boolean) = if (enabled) enabledContentColor else disabledContentColor
    fun containerColor(pressed: Boolean) = if (pressed) pressedContainerColor else enabledContainerColor
}

object FttcButtonDefaults {
    
    fun primaryButtonColors(): FttcButtonColors {
        return FttcButtonColors(
            enabledContentColor = FttcStyle.color.White,
            disabledContentColor = FttcStyle.color.Grey300,
            enabledContainerColor = FttcStyle.color.Primary,
            pressedContainerColor = FttcStyle.color.Blue700,
            disabledContainerColor = FttcStyle.color.Grey100
        )
    }

    fun buttonColors(): FttcButtonColors {
        return FttcButtonColors(
            enabledContentColor = FttcStyle.color.Grey900,
            disabledContentColor = FttcStyle.color.Grey300,
            enabledContainerColor = FttcStyle.color.White,
            pressedContainerColor = FttcStyle.color.Grey50,
            disabledContainerColor = FttcStyle.color.White
        )
    }

}

@Composable
fun BaseFttcButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LocalTextStyle.current,
    shape: Shape = ButtonDefaults.shape,
    colors: FttcButtonColors,
    border: BorderStroke? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.containerColor(pressed),
            disabledContainerColor = colors.disabledContainerColor
        ),
        border = border,
        enabled = enabled,
        shape = shape,
        contentPadding = PaddingValues(horizontal = 16.dp),
        interactionSource = interactionSource,
    ) {
        Text(
            text = text,
            style = textStyle,
            color = colors.contentColor(enabled)
        )
    }
}

@Composable
fun PrimaryFttcButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = BaseFttcButton(
    text = text,
    onClick = onClick,
    modifier.height(56.dp),
    enabled = enabled,
    textStyle = FttcStyle.typo.T3SemiBold,
    shape = RoundedCornerShape(12.dp),
    colors = FttcButtonDefaults.primaryButtonColors()
)

@Composable
fun PopupPrimaryFttcButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = BaseFttcButton(
    text = text,
    onClick = onClick,
    modifier.height(48.dp),
    enabled = enabled,
    textStyle = FttcStyle.typo.T4SemiBold,
    shape = RoundedCornerShape(8.dp),
    colors = FttcButtonDefaults.primaryButtonColors()
)

@Composable
fun FttcButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = BaseFttcButton(
    text = text,
    onClick = onClick,
    modifier.height(56.dp),
    enabled = enabled,
    textStyle = FttcStyle.typo.T3SemiBold,
    shape = RoundedCornerShape(12.dp),
    colors = FttcButtonDefaults.buttonColors(),
    border = BorderStroke(1.dp, FttcStyle.color.Grey150)
)

@Composable
fun PopupFttcButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = BaseFttcButton(
    text = text,
    onClick = onClick,
    modifier.height(48.dp),
    enabled = enabled,
    textStyle = FttcStyle.typo.T4SemiBold,
    shape = RoundedCornerShape(8.dp),
    colors = FttcButtonDefaults.buttonColors(),
    border = BorderStroke(1.dp, FttcStyle.color.Grey150)
)

@Preview
@Composable
fun PreviewPrimaryButton() {
    Column(Modifier.padding(10.dp)) {
        PrimaryFttcButton(
            text = "Primary Button",
            onClick = {},
            Modifier.width(220.dp)
        )
        Spacer(Modifier.height(8.dp))
        PrimaryFttcButton(
            text = "Primary Button",
            onClick = {},
            Modifier.width(220.dp),
            enabled = false
        )
        Spacer(Modifier.height(16.dp))
        PopupPrimaryFttcButton(
            text = "Popup Primary Button",
            onClick = {},
            Modifier.width(220.dp),
        )
        Spacer(Modifier.height(8.dp))
        PopupPrimaryFttcButton(
            text = "Popup Primary Button",
            onClick = {},
            Modifier.width(220.dp),
            enabled = false,
        )
    }
}

@Preview
@Composable
fun PreviewFttcButton() {
    Column(Modifier.padding(10.dp)) {
        FttcButton(
            text = "Button",
            onClick = {},
            Modifier.width(180.dp)
        )
        Spacer(Modifier.height(8.dp))
        FttcButton(
            text = "Button",
            onClick = {},
            Modifier.width(180.dp),
            enabled = false
        )

        // Preview PopupFttcButtons
        Spacer(Modifier.height(16.dp))
        PopupFttcButton(
            text = "Popup Button",
            onClick = {},
            Modifier.width(180.dp),
        )
        Spacer(Modifier.height(8.dp))
        PopupFttcButton(
            text = "Popup Button",
            onClick = {},
            Modifier.width(180.dp),
            enabled = false,
        )
    }
}


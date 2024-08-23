package com.playground.fttc.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playground.fttc.ui.theme.FttcStyle

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    BaseOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.height(52.dp),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = FttcStyle.typo.B2.copy(color = Color.Unspecified),
        placeholder = {
            Text(text = hint, style = FttcStyle.typo.B2.copy(FttcStyle.color.Grey300))
        },
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = FttcStyle.color.Grey150,
            unfocusedContainerColor = FttcStyle.color.White,
            unfocusedTextColor = FttcStyle.color.Grey800,
            focusedBorderColor = FttcStyle.color.Grey800,
            focusedContainerColor = FttcStyle.color.White,
            focusedTextColor = FttcStyle.color.Grey800,
            disabledBorderColor = FttcStyle.color.Grey200,
            disabledContainerColor = FttcStyle.color.Grey50,
            disabledTextColor = FttcStyle.color.Grey300,
            errorBorderColor = FttcStyle.color.RedNegative,
        )
    )
}

@Preview
@Composable
fun PreviewInputField() {
    Column(modifier = Modifier.padding(10.dp)) {

        var text by remember { mutableStateOf("") }

        InputField(text, { text = it}, Modifier.width(400.dp), hint = "Place Holder")
        Spacer(Modifier.height(16.dp))
        InputField("Disabled", { }, Modifier.width(400.dp), enabled = false)

        Spacer(Modifier.height(16.dp))
        InputField("Ready Only", { }, Modifier.width(400.dp), enabled = false, readOnly = false)

        Spacer(Modifier.height(16.dp))
        InputField("Error", { }, Modifier.width(400.dp), isError = true)
    }
}
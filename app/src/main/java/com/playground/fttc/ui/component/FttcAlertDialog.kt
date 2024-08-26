package com.playground.fttc.ui.component

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.playground.fttc.R
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

enum class DialogButtonWhich {
    POSITIVE, NEGATIVE, CANCEL
}

@Composable
fun FttcAlertDialog(
    message: String,
    buttonText: String = stringResource(id = R.string.button_okay),
    onConfirm: (() -> Unit)? = null
) = FttcAlertDialog(
    title = "",
    message = message,
    buttonText = buttonText,
    onConfirm = onConfirm,
)

@Composable
fun FttcAlertDialog(
    title: String,
    message: String,
    buttonText: String = stringResource(id = R.string.button_okay),
    onConfirm: (() -> Unit)? = null
) {
    Dialog(onDismissRequest = {}) {
        Surface(
            color = FttcStyle.color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier
                .width(380.dp)
                .wrapContentHeight()
                .padding(24.dp)
            ) {
                if (title.isNotBlank()) {
                    Text(
                        text = title,
                        style = FttcStyle.typo.T3Bold
                    )
                    Spacer(Modifier.height(16.dp))
                }
                Text(
                    text = message,
                    style = FttcStyle.typo.B2.copy(color = FttcStyle.color.Grey600)
                )
                Spacer(Modifier.height(24.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    PopupPrimaryFttcButton(
                        text = buttonText,
                        onClick = {
                            onConfirm?.invoke()
                        },
                        Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun FttcConfirmDialog(
    title: String,
    message: String,
    buttonText: String = stringResource(id = R.string.button_okay),
    onConfirm: (() -> Unit)? = null
) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Surface(
            color = FttcStyle.color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier
                .width(380.dp)
                .wrapContentHeight()
                .padding(24.dp)
            ) {
                if (title.isNotBlank()) {
                    Text(
                        text = title,
                        style = FttcStyle.typo.T3Bold
                    )
                    Spacer(Modifier.height(16.dp))
                }
                Text(
                    text = message,
                    style = FttcStyle.typo.B2.copy(color = FttcStyle.color.Grey600)
                )
                Spacer(Modifier.height(24.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    PopupFttcButton(
                        text = buttonText,
                        onClick = {
                            onConfirm?.invoke()
                        },
                        Modifier.weight(1f)
                    )
                    Spacer(Modifier.width(8.dp))
                    PopupPrimaryFttcButton(
                        text = buttonText,
                        onClick = {
                            onConfirm?.invoke()
                        },
                        Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAlertDialog() {
    FttcTheme {
        FttcAlertDialog(
            title = "From Java Programming",
            message = "Learn how to get started converting Java Programming Language",
            buttonText = "Okay"
        )
    }
}

@Preview
@Composable
fun PreviewNoTitleAlertDialog() {
    FttcTheme {
        FttcAlertDialog(
            "Learn how to get started converting Java Programming Language",
        )
    }
}

@Preview
@Composable
fun PreviewLongMessageAlertDialog() {
    val context = LocalContext.current
    FttcTheme {
        FttcAlertDialog("""
Dagger is a popular Dependency Injection framework commonly used in Android. 
It provides fully static and compile-time dependencies addressing many of the development and performance issues that have reflection-based solutions.
This month,a new tutorial was released to help you better understand how it works.
This article focuses on using Dagger with Kotlin, including best practices to optimize your build time and gotchas you might encounter.
            """.trimIndent(),
        ) {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview
@Composable
fun PreviewConfirmDialog() {
    FttcTheme {
        FttcConfirmDialog("title", "message")
    }
}
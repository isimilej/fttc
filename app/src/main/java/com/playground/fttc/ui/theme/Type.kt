package com.playground.fttc.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.playground.fttc.R

val Pretendards = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.pretendard_semibold, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.pretendard_bold, FontWeight.Bold, FontStyle.Normal),
)

val T32 = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.Normal,
    fontSize = 32.sp,
    lineHeight = 42.sp,
    letterSpacing = 0.5.sp
)

val T32SB = T32.copy(fontWeight = FontWeight.SemiBold)
val T32B = T32.copy(fontWeight = FontWeight.Bold)

val T28 = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 40.sp,
    letterSpacing = 0.5.sp
)
val T28SB = T28.copy(fontWeight = FontWeight.SemiBold)
val T28B = T28.copy(fontWeight = FontWeight.Bold)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
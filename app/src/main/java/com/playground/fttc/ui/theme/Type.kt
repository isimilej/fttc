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
    Font(R.font.pretendard_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.pretendard_bold, FontWeight.Bold, FontStyle.Normal),
)

object FttcTypo {
    val H1 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 42.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )

    val H1Bold = H1.copy(fontWeight = FontWeight.Bold)
    val H1SemiBold = H1.copy(fontWeight = FontWeight.SemiBold)

    val H2 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val H2Bold = H2.copy(fontWeight = FontWeight.Bold)
    val H2SemiBold = H2.copy(fontWeight = FontWeight.SemiBold)

    val H3 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val H3Bold = H3.copy(fontWeight = FontWeight.Bold)
    val H3SemiBold = H3.copy(fontWeight = FontWeight.SemiBold)

    val T1 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val T1Bold = T1.copy(fontWeight = FontWeight.Bold)
    val T1SemiBold = T1.copy(fontWeight = FontWeight.SemiBold)

    val T2 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val T2Bold = T2.copy(fontWeight = FontWeight.Bold)
    val T2SemiBold = T2.copy(fontWeight = FontWeight.SemiBold)

    val T3 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val T3Bold = T3.copy(fontWeight = FontWeight.Bold)
    val T3SemiBold = T3.copy(fontWeight = FontWeight.SemiBold)

    val T4 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val T4Bold = T4.copy(fontWeight = FontWeight.Bold)
    val T4SemiBold = T4.copy(fontWeight = FontWeight.SemiBold)

    val B1 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val B1Bold = B1.copy(fontWeight = FontWeight.Bold)
    val B1SemiBold = B1.copy(fontWeight = FontWeight.SemiBold)

    val B2 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val B2Bold = B2.copy(fontWeight = FontWeight.Bold)
    val B2SemiBold = B2.copy(fontWeight = FontWeight.SemiBold)

    val B3 = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.5).sp,
        color = FttcStyle.color.Grey900,
    )
    val B3Bold = B3.copy(fontWeight = FontWeight.Bold)
    val B3SemiBold = B3.copy(fontWeight = FontWeight.SemiBold)

}


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


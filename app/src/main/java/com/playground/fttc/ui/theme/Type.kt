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

val T32 = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.Normal,
    fontSize = 32.sp,
    lineHeight = 42.sp,
    letterSpacing = 0.5.sp
)

val T32SB = T32.copy(fontWeight = FontWeight.SemiBold)
val T32B = T32.copy(fontWeight = FontWeight.Bold)
//
////styleName: Heading/Headline 1/32 B;
//font-family: Pretendard;
//font-size: 32px;
//font-weight: 700;
//line-height: 42px;
//letter-spacing: -0.5px;
//text-align: left;
//



object FttcTextStyle {
    val HeadLineLarge = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 42.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val HeadLineLargeBold = HeadLineLarge.copy(fontWeight = FontWeight.Bold)
    val HeadLineLargeSemiBold = HeadLineLarge.copy(fontWeight = FontWeight.SemiBold)

    val HeadLine = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val HeadLineBold = HeadLine.copy(fontWeight = FontWeight.Bold)
    val HeadLineSemiBold = HeadLine.copy(fontWeight = FontWeight.SemiBold)

    val HeadLineSmall = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val HeadLineSmallBold = HeadLineSmall.copy(fontWeight = FontWeight.Bold)
    val HeadLineSmallSemiBold = HeadLineSmall.copy(fontWeight = FontWeight.SemiBold)

    val TitleLarge = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val TitleLargeBold = TitleLarge.copy(fontWeight = FontWeight.Bold)
    val TitleLargeSemiBold = TitleLarge.copy(fontWeight = FontWeight.SemiBold)

    val TitleMedium = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val TitleMediumBold = TitleMedium.copy(fontWeight = FontWeight.Bold)
    val TitleMediumSemiBold = TitleMedium.copy(fontWeight = FontWeight.SemiBold)

    val Title = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val TitleBold = Title.copy(fontWeight = FontWeight.Bold)
    val TitleSemiBold = Title.copy(fontWeight = FontWeight.SemiBold)

    val TitleSmall = TextStyle(
        fontFamily = Pretendards,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.5).sp,
        color = FttcColor.Grey900,
    )
    val TitleSmallBold = TitleSmall.copy(fontWeight = FontWeight.Bold)
    val TitleSmallSemiBold = TitleSmall.copy(fontWeight = FontWeight.SemiBold)

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


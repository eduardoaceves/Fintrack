/*
 * Type.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import course.shared.generated.resources.Res
import course.shared.generated.resources.open_sans
import org.jetbrains.compose.resources.Font

val fontFamily
    @Composable get() = FontFamily(
        Font(resource = Res.font.open_sans, weight = FontWeight.Normal),
        Font(resource = Res.font.open_sans, weight = FontWeight.Bold),
    )

val MaterialThemAppTypography
    @Composable
    get() = Typography(
        headlineLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeBig,
        ),
        titleLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeBig,
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeBig,
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeBig,
        ),
        headlineMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeMedium,
        ),
        titleMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeMedium,
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeMedium,
        ),
        labelMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeMedium,
        ),
        headlineSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeSmall,
        ),
        titleSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeSmall,
        ),
        bodySmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeSmall,
        ),
        labelSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeSmall,
        ),
    )

@Immutable
data class AppTypography(
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodyNormal: TextStyle,
    val bodySmall: TextStyle,
    val bodyExtraSmall: TextStyle,
)

val appTypography
    @Composable get() = AppTypography(
        bodyLarge = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig),
        bodyMedium = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium),
        bodyNormal = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal),
        bodySmall = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall),
        bodyExtraSmall = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall),
    )

@Immutable
data class AppSpanStyle(
    val bodyLarge: SpanStyle,
)

val appSpanStyle @Composable get() =
    AppSpanStyle(bodyLarge = SpanStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig))

/*
 * ColorsLight.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme.colors

import androidx.compose.ui.graphics.Color
import com.uagr.kmp.course.presentation.theme.colors.backgroundGreenActiveDark

val primaryLight = Color(0xFF0F459E)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0xFFE6F4F4)
val onPrimaryContainerLight = Color(0xFF637070)
val secondaryLight = Color(0xFFA3A3A3)
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFDCE0E0)
val onSecondaryContainerLight = Color(0xFF5F6363)
val tertiaryLight = Color(0xFFCB5856)
val onTertiaryLight = Color(0xFFFFFFFF)
val tertiaryContainerLight = Color(0xFFF3EFFE)
val onTertiaryContainerLight = Color(0xFF6E6C78)
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF93000A)
val backgroundLight = Color(0xFFF4F4F4)
val onBackgroundLight = Color(0xFF1B1C1C)
val surfaceLight = Color(0xFFFBF9F8)
val onSurfaceLight = Color(0xFF1B1C1C)
val surfaceVariantLight = Color(0xFFDFE3E3)
val onSurfaceVariantLight = Color(0xFF424848)
val outlineLight = Color(0xFF737878)
val outlineVariantLight = Color(0xFFC2C7C7)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF303030)
val inverseOnSurfaceLight = Color(0xFFF3F0EF)
val inversePrimaryLight = Color(0xFFBBC9C9)
val surfaceDimLight = Color(0xFFDCD9D9)
val surfaceBrightLight = Color(0xFFFBF9F8)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF5F3F2)
val surfaceContainerLight = Color(0xFFF0EDED)
val surfaceContainerHighLight = Color(0xFFEAE8E7)
val surfaceContainerHighestLight = Color(0xFFE4E2E1)
// --- Light Status Colors ---
val statusErrorLight = Color(0xFFF75555)
val statusErrorContainerLight = Color(0xFFFFEFED)
val statusWarningLight = Color(0xFFFACC15)
val statusWarningContainerLight = Color(0xFFFFFBEB)
val statusInfoLight = Color(0xFF235DFF)
val statusInfoContainerLight = Color(0xFFEBF8F3)
val statusSuccessLight = Color(0xFF12D18E)
val statusSuccessContainerLight = Color(0xFFEBF8F3)
// --- Light Texts Colors ---
val textBlackLight = Color(0xFF000000)
val textWhiteLight = Color(0xFFFFFFFF)
val textLinkLight = Color(0xFF1470D1)
val textBLueLight = Color(0xFF1A70ED)
val textGrayLight = Color(0xFF7A8291)
val textGreenLight = Color(0xFF17A36E)
// --- Dark Backgrounds Colors ---
val backgroundBlackLight = Color(0xFF000000)
val backgroundWhiteLight = Color(0xFFFFFFFF)
val backgroundYellowLight = Color(0xFFFFB700)
val backgroundBlueLight = Color(0xFF1A70ED)
val dividerLight = Color(0xFFEBEFF9)
val backgroundProgressIndicatorLight = Color(0x80898989)
val backgroundGreenLight = Color(0xFFE5FAF2)
val backgroundRedLight = Color(0xFFFFEDF0)
val backgroundRedActiveLight = Color(0xFFE5454D)
val backgroundGreenActiveLight = Color(0xFF17A36E)
val backgroundCanvasLight = Color(0xFFf5f7fa)

// --- Light color group ---
val lightModeAppColors = AppColors(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
    status = ColorStatus(
        error = statusErrorLight,
        errorContainer = statusErrorContainerLight,
        warning = statusWarningLight,
        warningContainer = statusWarningContainerLight,
        info = statusInfoLight,
        infoContainer = statusInfoContainerLight,
        success = statusSuccessLight,
        successContainer = statusSuccessContainerLight,
    ),
    text = ColorTexts(
        black = textBlackLight,
        white = textWhiteLight,
        blue  = textBLueLight,
        link = textLinkLight,
        gray = textGrayLight,
        green = textGreenLight,
    ),
    backgrounds = ColorBackgrounds(
        black = backgroundBlackLight,
        white = backgroundWhiteLight,
        yellow = backgroundYellowLight,
        blue = backgroundBlueLight,
        red = backgroundRedLight,
        redActive = backgroundRedActiveLight,
        green = backgroundGreenLight,
        greenActive = backgroundGreenActiveLight,
        canvas = backgroundCanvasLight,
    ),
    divider = dividerLight,
    backgroundProgressIndicator = backgroundProgressIndicatorLight,
)

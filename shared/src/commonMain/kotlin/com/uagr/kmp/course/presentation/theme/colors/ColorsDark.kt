/*
 * ColorsDark.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme.colors

import androidx.compose.ui.graphics.Color

val primaryDark = Color(0xFF0F459E)
val onPrimaryDark = Color(0xFFFFFFFF)
val primaryContainerDark = Color(0xFFE6F4F4)
val onPrimaryContainerDark = Color(0xFF637070)
val secondaryDark = Color(0xFFA3A3A3)
val onSecondaryDark = Color(0xFFFFFFFF)
val secondaryContainerDark = Color(0xFFDCE0E0)
val onSecondaryContainerDark = Color(0xFF5F6363)
val tertiaryDark = Color(0xFFCB5856)
val onTertiaryDark = Color(0xFFFFFFFF)
val tertiaryContainerDark = Color(0xFFF3EFFE)
val onTertiaryContainerDark = Color(0xFF6E6C78)
val errorDark = Color(0xFFBA1A1A)
val onErrorDark = Color(0xFFFFFFFF)
val errorContainerDark = Color(0xFFFFDAD6)
val onErrorContainerDark = Color(0xFF93000A)
val backgroundDark = Color(0xFFF4F4F4)
val onBackgroundDark = Color(0xFF1B1C1C)
val surfaceDark = Color(0xFFFBF9F8)
val onSurfaceDark = Color(0xFF1B1C1C)
val surfaceVariantDark = Color(0xFFDFE3E3)
val onSurfaceVariantDark = Color(0xFF424848)
val outlineDark = Color(0xFF737878)
val outlineVariantDark = Color(0xFFC2C7C7)
val scrimDark = Color(0xFF000000)
val inverseSurfaceDark = Color(0xFF303030)
val inverseOnSurfaceDark = Color(0xFFF3F0EF)
val inversePrimaryDark = Color(0xFFBBC9C9)
val surfaceDimDark = Color(0xFFDCD9D9)
val surfaceBrightDark = Color(0xFFFBF9F8)
val surfaceContainerLowestDark = Color(0xFFFFFFFF)
val surfaceContainerLowDark = Color(0xFFF5F3F2)
val surfaceContainerDark = Color(0xFFF0EDED)
val surfaceContainerHighDark = Color(0xFFEAE8E7)
val surfaceContainerHighestDark = Color(0xFFE4E2E1)
// --- Dark Status Colors ---
val statusErrorDark = Color(0xFFF75555)
val statusErrorContainerDark = Color(0xFFFFEFED)
val statusWarningDark = Color(0xFFFACC15)
val statusWarningContainerDark = Color(0xFFFFFBEB)
val statusInfoDark = Color(0xFF235DFF)
val statusInfoContainerDark = Color(0xFFEBF8F3)
val statusSuccessDark = Color(0xFF12D18E)
val statusSuccessContainerDark = Color(0xFFEBF8F3)
// --- Dark Texts Colors ---
val textBlackDark = Color(0xFF000000)
val textWhiteDark = Color(0xFFFFFFFF)
val textLinkDark = Color(0xFF1470D1)
val textBLueDark = Color(0xFF1A70ED)
val textGrayDark = Color(0xFF7A8291)
val textGreenDark = Color(0xFF17A36E)
// --- Dark Backgrounds Colors ---
val backgroundBlackDark = Color(0xFF000000)
val backgroundWhiteDark = Color(0xFFFFFFFF)
val backgroundYellowDark = Color(0xFFFFB700)
val backgroundBlueDark = Color(0xFF1A70ED)
val dividerDark = Color(0xFFEBEFF9)
val backgroundProgressIndicatorDark = Color(0x80898989)
val backgroundGreenDark = Color(0xFFE5FAF2)
val backgroundRedDark = Color(0xFFFFEDF0)
val backgroundRedActiveDark = Color(0xFFE5454D)
val backgroundGreenActiveDark = Color(0xFF17A36E)
val backgroundCanvasDark = Color(0xFFf5f7fa)

// --- Dark color group ---
val darkModeAppColors = AppColors(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
    status = ColorStatus(
        error = statusErrorDark,
        errorContainer = statusErrorContainerDark,
        warning = statusWarningDark,
        warningContainer = statusWarningContainerDark,
        info = statusInfoDark,
        infoContainer = statusInfoContainerDark,
        success = statusSuccessDark,
        successContainer = statusSuccessContainerDark,
    ),
    text = ColorTexts(
        black = textBlackDark,
        white = textWhiteDark,
        link = textLinkDark,
        blue  = textBLueDark,
        gray = textGrayDark,
        green = textGreenDark,
    ),
    backgrounds = ColorBackgrounds(
        black = backgroundBlackDark,
        white = backgroundWhiteDark,
        yellow = backgroundYellowDark,
        blue = backgroundBlueDark,
        green = backgroundGreenDark,
        greenActive = backgroundGreenActiveDark,
        red = backgroundRedDark,
        redActive = backgroundRedActiveDark,
        canvas = backgroundCanvasDark
    ),
    divider = dividerDark,
    backgroundProgressIndicator = backgroundProgressIndicatorDark,
)

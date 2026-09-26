/*
 * Theme.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import com.uagr.kmp.course.presentation.theme.colors.AppColors
import com.uagr.kmp.course.presentation.theme.colors.darkModeAppColors
import com.uagr.kmp.course.presentation.theme.colors.lightModeAppColors

internal val LocalThemeIsDark = compositionLocalOf { true }
internal val LocalAppColors = staticCompositionLocalOf { lightModeAppColors }
internal val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("Typography not provided") }
internal val LocalAppSpanStyle = staticCompositionLocalOf<AppSpanStyle> { error("SpanStyle not provided") }

@Composable
fun AppTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkMode,
        LocalAppColors provides if (isDarkMode) darkModeAppColors else lightModeAppColors,
        LocalAppTypography provides appTypography,
        LocalAppSpanStyle provides appSpanStyle,
    ) {
        SystemAppearance(isDarkMode = isDarkMode)
        MaterialTheme(
            colorScheme = LocalAppColors.current.asMaterialColorScheme(isDarkMode),
            typography = MaterialThemAppTypography,
        ) {
            content()
        }
    }
}

object AppTheme {

    val colors: AppColors @Composable @ReadOnlyComposable get() =
        LocalAppColors.current

    val typography: AppTypography
        @Composable @ReadOnlyComposable get() =
        LocalAppTypography.current

    val spanStyle: AppSpanStyle
        @Composable @ReadOnlyComposable get() =
        LocalAppSpanStyle.current
}

@Composable
internal expect fun SystemAppearance(isDarkMode: Boolean)

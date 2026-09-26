/*
 * Theme.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat
import com.uagr.kmp.course.presentation.theme.AppTheme

@Suppress("DEPRECATION")
@Composable
internal actual fun SystemAppearance(isDarkMode: Boolean) {
    val view = LocalView.current
    val statusBarColor = AppTheme.colors.primary.toArgb()
    val navigationBarColor = AppTheme.colors.primary.toArgb()
    LaunchedEffect(key1 = isDarkMode) {
        val window = (view.context as Activity).window
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = isDarkMode
            isAppearanceLightNavigationBars = isDarkMode
        }
        window.statusBarColor = statusBarColor
        window.navigationBarColor = navigationBarColor
    }
}

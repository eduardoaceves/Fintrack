/*
 * Theme.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.setStatusBarStyle

@Composable
internal actual fun SystemAppearance(isDarkMode: Boolean) {
    LaunchedEffect(key1 = isDarkMode) {
        UIApplication.sharedApplication.setStatusBarStyle(
            if (isDarkMode) UIStatusBarStyleDarkContent else UIStatusBarStyleLightContent
        )
    }
}

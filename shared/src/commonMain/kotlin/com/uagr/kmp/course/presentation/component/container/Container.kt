/*
 * Container.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.SystemAppearance

@Composable
fun SafeScreenContainer(
    modifier: Modifier = Modifier,
    systemColor: Color = AppTheme.colors.primary,
    backgroundColor: Color = AppTheme.colors.background,
    isSystemIconsDark: Boolean? = null,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit,
) {
    isSystemIconsDark?.let {
        SystemAppearance(isDarkMode = isSystemIconsDark)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = systemColor,
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(color = backgroundColor),
            contentAlignment = contentAlignment,
        ) {
            content()
        }
    }
}

@Composable
fun SafeScreenContainerTest(
    modifier: Modifier = Modifier,
    systemColor: Color = AppTheme.colors.primary,
    backgroundColor: Color = AppTheme.colors.background,
    content: @Composable BoxScope.() -> Unit,
) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = systemColor,
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .background(color = backgroundColor),
            ) {
                content()
            }
        }
    }
}

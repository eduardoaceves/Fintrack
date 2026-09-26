/*
 * HeatScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.welcome.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest

@Composable
fun WelcomeScreen(
    navigateToPackages: () -> Unit = {},
) {
    SafeScreenContainer {
        WelcomeContainer(
            navigateToPackages = navigateToPackages,
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun WelcomeScreenPreview() {
    SafeScreenContainerTest {
        WelcomeScreen()
    }
}

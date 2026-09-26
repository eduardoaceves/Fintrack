/*
 * PackagesNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.packages.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.uagr.kmp.course.presentation.ui.packages.ui.PackagesScreen

data object PackagesNavigation : Screen {
    @Composable
    override fun Content() {
        PackagesScreen()
    }
}

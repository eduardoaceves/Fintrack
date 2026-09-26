/*
 * PackagesScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.packages.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.ui.packages.viewmodel.PackagesUiEvent
import com.uagr.kmp.course.presentation.ui.packages.viewmodel.PackagesViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PackagesScreen(
    viewmodel: PackagesViewModel = koinViewModel(),
) {
    val packagesUiState by viewmodel.packagesUiState.collectAsState()
    val packagesUiEvent by viewmodel.packagesUiEvent.collectAsState()

    SafeScreenContainer {
        PackagesContainer(
            packages = packagesUiState.packages,
            activePackagesClick = {},
        )
        Loader(isLoading = packagesUiState.isLoading)
    }

    when (packagesUiEvent) {
        is PackagesUiEvent.Idle -> {}
        is PackagesUiEvent.ShowErrorDialog -> {}
        is PackagesUiEvent.ShowErrorStringDialog -> {}
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun PackagesScreenPreview() {
    SafeScreenContainerTest {
        PackagesScreen()
    }
}

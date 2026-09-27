/*
 * HomeTabScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_home
import org.jetbrains.compose.resources.painterResource

object HomeTabScreen : Tab {
    
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Inicio",
                    icon = icon
                )
            }
        }
    
    @Composable
    override fun Content() {
        HomeScreenContainer()
    }
    
    
}
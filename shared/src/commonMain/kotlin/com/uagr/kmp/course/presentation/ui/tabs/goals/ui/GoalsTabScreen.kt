/*
 * GoalsTabScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.goals.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.theme.AppTheme
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_goals
import org.jetbrains.compose.resources.painterResource

object GoalsTabScreen : Tab {
    
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_goals)
            return remember {
                TabOptions(
                    index = 3u,
                    title = "Metas",
                    icon = icon
                )
            }
        }
    
    @Composable
    override fun Content() {
        SafeScreenContainer(
            modifier = Modifier.background(color = AppTheme.colors.backgrounds.canvas)
        ) {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                GoalsScreenContainer()
            }
        }
    }
    
    
}
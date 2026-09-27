/*
 * BudgetTabScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.budget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_budget
import org.jetbrains.compose.resources.painterResource

object BudgetTabScreen : Tab {
    
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_budget)
            return remember {
                TabOptions(
                    index = 2u,
                    title = "Presupuesto",
                    icon = icon
                )
            }
        }
    
    @Composable
    override fun Content() {
        Box(
            Modifier.fillMaxSize().background(Color.Red),
            contentAlignment = Alignment.Center)
        {
            TextBigBold(
                text = "BudgetScreen",
                color = AppTheme.colors.text.black
            )
        }
    }
    
    
}
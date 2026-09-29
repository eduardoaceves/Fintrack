/*
 * HomeNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.home.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.presentation.theme.Dimens.textSize10sp
import com.uagr.kmp.course.presentation.ui.tabs.budget.ui.BudgetTabScreen
import com.uagr.kmp.course.presentation.ui.tabs.goals.ui.GoalsTabScreen
import com.uagr.kmp.course.presentation.ui.tabs.home.ui.HomeTabScreen
import com.uagr.kmp.course.presentation.ui.tabs.transactions.iu.TransactionsTabScreen

data object HomeNavigation : Screen  {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        SafeScreenContainer {
            TabNavigator(HomeTabScreen) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar(
                            containerColor = AppTheme.colors.backgrounds.white,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(topStart = Dimens.corner22, topEnd = Dimens.corner22))
                        ) {
                            TabNavigationItem(HomeTabScreen )
                            TabNavigationItem(TransactionsTabScreen)
                            TabNavigationItem(BudgetTabScreen)
                            TabNavigationItem(GoalsTabScreen)
                        }
                    }
                ) {
                    CurrentTab()
                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val navigator = LocalTabNavigator.current
    val textColor = if(navigator.current == tab) AppTheme.colors.text.blue else AppTheme.colors.text.gray
    NavigationBarItem(
        selected = navigator.current == tab,
        onClick = { navigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    modifier = Modifier.size(Dimens.height22),
                    tint = if(navigator.current == tab) AppTheme.colors.text.blue else AppTheme.colors.text.gray,
                    contentDescription = null,
                )
            }
        },
        label = {
            TextSmallExtra(
                text = tab.options.title,
                fontSize = textSize10sp,
                color =  textColor
            )
        }
    )
}





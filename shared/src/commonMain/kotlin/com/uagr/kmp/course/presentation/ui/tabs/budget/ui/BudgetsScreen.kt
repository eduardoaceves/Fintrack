/*
 * BudgetsScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.budget.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.tabs.budget.viewmodel.BudgetsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BudgetsScreen(
    viewModel : BudgetsViewModel = koinViewModel(),
){
    val budgetsUiState by viewModel.budgetsUiState.collectAsStateWithLifecycle()
    
    SafeScreenContainer(
        modifier = Modifier.background(color = AppTheme.colors.backgrounds.canvas)
    ) {
        BudgetScreenContainer(
            budgetSummary = budgetsUiState.budgetSummary,
            budgets = budgetsUiState.budgets,
        )
        //Loader(isLoading = budgetsUiState.isLoading)
        DialogCustom(
            errorDialog = budgetsUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BudgetsScreenPreview() {
    SafeScreenContainerTest {
        BudgetsScreen()
    }
}
/*
 * BudgetsUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.budget.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.domain.model.transations.TransactionItemModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class BudgetsUiState(
    val budgetSummary : BudgetSummaryModel? = null,
    val budgets : BudgetsModel? = null,
    val errorDialog : ErrorDialogModel? = null,
    val isLoading : StatusLoading = StatusLoading.DISMISS_LOADING,
)

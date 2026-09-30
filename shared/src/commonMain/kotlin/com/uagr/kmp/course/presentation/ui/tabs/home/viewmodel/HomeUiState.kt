/*
 * HomeUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel

import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.domain.model.transations.TransactionItemModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class HomeUiState (
    val account : AccountModel? = null,
    val accounts : AccountsDataModel? = null,
    val summary : SummaryDataModel? = null,
    val transactions : TransactionsDataModel? = null,
    val errorDialog : ErrorDialogModel? = null,
    val errorTransactions : Boolean = false,
    val errorEmptyAccounts : Boolean = false,
    val isLoading : StatusLoading = StatusLoading.DISMISS_LOADING,
)
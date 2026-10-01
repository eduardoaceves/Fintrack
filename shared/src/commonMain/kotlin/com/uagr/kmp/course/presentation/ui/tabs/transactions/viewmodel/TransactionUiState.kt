/*
 * TransactionUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.transactions.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class TransactionUiState(
    val searchText : String = "",
    val isSearching : Boolean = false,
    val transactions : TransactionsDataModel? = null,
    val errorDialog : ErrorDialogModel? = null,
    val errorTransactions : Boolean = false,
    val isLoading : StatusLoading = StatusLoading.DISMISS_LOADING,
)

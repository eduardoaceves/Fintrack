/*
 * BudgetsViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.budget.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.mapper.packages.toEntity
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.domain.usecase.accounts.GetLocalAccountIdUseCase
import com.uagr.kmp.course.domain.usecase.budgets.GetBudgetSummaryUseCase
import com.uagr.kmp.course.domain.usecase.budgets.GetBudgetsUseCase
import com.uagr.kmp.course.domain.usecase.transactions.GetLastMovesUseCase
import com.uagr.kmp.course.presentation.component.mock.budgetsDataMock
import com.uagr.kmp.course.presentation.ui.packages.viewmodel.PackagesUiEvent
import com.uagr.kmp.course.presentation.ui.tabs.transactions.viewmodel.TransactionUiState
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.Factory

@Factory
class BudgetsViewModel(
    private val getBudgetSummaryUseCase: GetBudgetSummaryUseCase,
    private val getBudgetsUseCase: GetBudgetsUseCase
) : ViewModel()  {
    
    private var _budgetsUiUiState = MutableStateFlow(BudgetsUiState())
    val budgetsUiState: StateFlow<BudgetsUiState> = _budgetsUiUiState.asStateFlow()
    
    init{
        getBudgetSummary()
    }
    
    fun getBudgetSummary() = viewModelScope.launch {
        getBudgetSummaryUseCase(NetworkUrl.BUDGET_SUMMARY_ENDPOINT)
            .onStart {
                _budgetsUiUiState.update { it.copy(isLoading = StatusLoading.SHOW_LOADING) }
            }
            .catch { exception ->
                _budgetsUiUiState.update {
                    it.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorDialog = exception.message?.let { message ->
                            ErrorDialogModel(
                                title = "Error",
                                message = message
                            )
                        }
                    )
                }
            }
            .collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _budgetsUiUiState.update {
                            it.copy(
                                budgetSummary = result.response,
                                isLoading = StatusLoading.DISMISS_LOADING
                            )
                        }
                        getBudgets()
                    }
                    is NetworkResult.Error -> {
                        _budgetsUiUiState.update {
                            it.copy(
                                isLoading = StatusLoading.DISMISS_LOADING,
                                errorDialog = ErrorDialogModel(
                                    message = result.message
                                )
                            )
                        }
                    }
                }
            }
    }
    
    fun getBudgets() = viewModelScope.launch {
        _budgetsUiUiState.update {
            it.copy(
                budgets = budgetsDataMock,
                isLoading = StatusLoading.DISMISS_LOADING
            )
        }
        /*getBudgetsUseCase(NetworkUrl.BUDGETS_ENDPOINT)
            .catch {
                _budgetsUiUiState.update {
                    it.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorDialog = ErrorDialogModel(
                            message = getString( Res.string.please_try_again_later)
                        )
                    )
                }
            }.collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _budgetsUiUiState.update {
                            it.copy(
                                budgets = result.response,
                                isLoading = StatusLoading.DISMISS_LOADING
                            )
                        }
                    }
                    is NetworkResult.Error -> {
                        _budgetsUiUiState.update {
                            it.copy(
                                isLoading = StatusLoading.DISMISS_LOADING,
                                errorDialog = ErrorDialogModel(
                                    message = result.message
                                )
                            )
                        }
                    }
                }
            }*/
    }
    
}
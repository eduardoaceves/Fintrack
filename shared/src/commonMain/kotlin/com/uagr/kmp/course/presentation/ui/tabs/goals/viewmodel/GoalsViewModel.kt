/*
 * GoalsViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.goals.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.user.DeleteAllUsersUseCase
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
class GoalsViewModel(
    private val closeSessionUseCase: DeleteAllUsersUseCase,
) : ViewModel()  {
    
    private var _goalsUiState = MutableStateFlow(GoalsUiState())
    val goalsUiState: StateFlow<GoalsUiState> = _goalsUiState.asStateFlow()
    
    private var _goalsUIEvent = MutableStateFlow<GoalsUiEvent>(GoalsUiEvent.Idle)
    val goalsUiEvent: StateFlow<GoalsUiEvent> = _goalsUIEvent.asStateFlow()
    
    fun closeSession() = viewModelScope.launch {
        closeSessionUseCase()
            .catch {
                _goalsUiState.update {
                    it.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorDialog = ErrorDialogModel(
                            message = getString( Res.string.please_try_again_later)
                        )
                    )
                }
            }
            .onStart {
                _goalsUiState.update { it.copy(isLoading = StatusLoading.SHOW_LOADING) }
            }.collect {
                _goalsUiState.update { it.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                _goalsUIEvent.value = GoalsUiEvent.CloseSessionSuccess
            }
    }
    
    fun resetUiEvent() = viewModelScope.launch  {
        _goalsUIEvent.value = GoalsUiEvent.Idle
    }
    
    /*fun getBudgetSummary() = viewModelScope.launch {
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
        /*_budgetsUiUiState.update {
            it.copy(
                budgets = budgetsDataMock,
                isLoading = StatusLoading.DISMISS_LOADING
            )
        }*/
        getBudgetsUseCase(NetworkUrl.BUDGETS_ENDPOINT)
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
            }
    }*/
    
}
/*
 * TransactionViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.usecase.accounts.GetLocalAccountIdUseCase
import com.uagr.kmp.course.domain.usecase.transactions.GetLastMovesUseCase
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
class TransactionViewModel(
    private val getLastMovesUseCase: GetLastMovesUseCase,
    private val getLocalAccountIdUseCase : GetLocalAccountIdUseCase,
) : ViewModel()  {
    
    private var _transactionsUiState = MutableStateFlow(TransactionUiState())
    val transactionsUiState: StateFlow<TransactionUiState> = _transactionsUiState.asStateFlow()
    
    init{
        getLocalAccountId()
    }
    
    fun onSearchTextChange(text : String) {
        _transactionsUiState.update { state -> state.copy(searchText = text) }
    }
    
    private fun getLocalAccountId() = viewModelScope.launch {
        getLocalAccountIdUseCase()
            .onStart {
                _transactionsUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
            }.catch {
                _transactionsUiState.update { state ->
                    state.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorTransactions = true
                    )
                }
            } .collect { accountId ->
                getLastMoves(accountId = accountId)
            }

    }
    
    private fun getLastMoves(accountId : String) = viewModelScope.launch {
        if(accountId.isNotEmpty()){
            getLastMovesUseCase(
                accountId = accountId,
                url = NetworkUrl.GET_TRANSACTIONS_ENDPOINT
            ).onStart {
            
            }.catch {
                _transactionsUiState.update { state ->
                    state.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorTransactions = true
                    )
                }
            }.collect { result ->
                when(result) {
                    is NetworkResult.Success -> {
                        result.response.let { transactions ->
                            _transactionsUiState.update { state ->
                                state.copy(isLoading = StatusLoading.DISMISS_LOADING,
                                    transactions = transactions
                                )
                            }
                        }
                    }
                    is NetworkResult.Error -> {
                        _transactionsUiState.update { state ->
                            state.copy(
                                isLoading = StatusLoading.DISMISS_LOADING,
                                errorTransactions = true
                            )
                        }
                    }
                }
            }
        }
    }
}
/*
 * TransactionViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.mapper.packages.toEntity
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.domain.usecase.accounts.GetLocalAccountIdUseCase
import com.uagr.kmp.course.domain.usecase.transactions.GetLastMovesUseCase
import com.uagr.kmp.course.utils.constant.Constants
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
    
    fun onSearchTextChange(searchText : String) {
        _transactionsUiState.update { state -> state.copy(searchText = searchText) }
        updateFilter(searchText = searchText)
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
                                    transactions = transactions,
                                    filter = transactions.items,
                                    transactionList = transactions.items,
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
    
    fun filterTransactions(filter : String){
        updateFilter(searchText = filter)
        /*_transactionsUiState.update {
            state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING, searchText = filter)
        }*/
    }
    
    private fun updateFilter(searchText: String){
        if(transactionsUiState.value.transactions != null) {
           val transactions = transactionsUiState.value.transactions
            val filter = if(searchText.isEmpty()) {
                transactions?.items
            } else {
                transactions?.items?.filter {
                    it.description.lowercase().contains(searchText.lowercase(), ignoreCase = false) ||
                            it.notes.lowercase().contains(searchText.lowercase(), ignoreCase = false) ||
                            it.type.lowercase().contains(searchText.lowercase(), ignoreCase = false)
                }
            }
            _transactionsUiState.update { state ->
                state.copy(isLoading = StatusLoading.DISMISS_LOADING,
                    filter = filter,
                )
            }
        }
    }
    
}
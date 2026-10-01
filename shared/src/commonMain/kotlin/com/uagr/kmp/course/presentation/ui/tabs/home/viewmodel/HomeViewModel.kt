/*
 * HomeViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.accounts.GetAccountsUseCase
import com.uagr.kmp.course.domain.usecase.accounts.InsertAndDeleteAccountUseCase
import com.uagr.kmp.course.domain.usecase.summary.SummaryUseCase
import com.uagr.kmp.course.domain.usecase.transactions.GetLastMovesUseCase
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Accept
import course.shared.generated.resources.Res
import course.shared.generated.resources.empty_accounts
import course.shared.generated.resources.error
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getAccountsUseCase: GetAccountsUseCase,
    private val getSummaryUseCase: SummaryUseCase,
    private val getLastMovesUseCase: GetLastMovesUseCase,
    private val insertAndDeleteAccountUseCase: InsertAndDeleteAccountUseCase,
) : ViewModel() {
    
    private var _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()
    
    private var _homeUiEvent = MutableStateFlow<HomeUiEvent>(HomeUiEvent.Idle)
    val homeUiEvent: StateFlow<HomeUiEvent> = _homeUiEvent.asStateFlow()
    
    init{
        getAccounts()
    }
    
    private fun getAccounts() = viewModelScope.launch{
        getAccountsUseCase(url = NetworkUrl.GET_ACCOUNTS_ENDPOINT)
            .onStart {
                _homeUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
            }
            .catch {
                _homeUiState.update { state -> state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = setErrorDialog(),
                ) }
            }.collect { result ->
                when(result){
                    is NetworkResult.Success -> {
                        result.response.let{ accounts ->
                            if(accounts.items.isNotEmpty()){
                                saveAccountID(accountsDataModel = accounts)
                            } else {
                                _homeUiState.update { state ->
                                    state.copy(
                                        isLoading = StatusLoading.DISMISS_LOADING,
                                        errorDialog = setErrorDialog(getString(Res.string.empty_accounts)),
                                    )
                                }
                            }
                        }
                    }
                    is NetworkResult.Error -> {
                        _homeUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                        _homeUiState.update { state ->
                            state.copy(
                                isLoading = StatusLoading.DISMISS_LOADING,
                                errorDialog = setErrorDialog(message =
                                    result.message.ifEmpty {
                                        getString(Res.string.please_try_again_later)
                                    }
                                )
                            )
                        }
                    }
                }
            }
    }
    
    private fun saveAccountID(accountsDataModel: AccountsDataModel) = viewModelScope.launch {
        if(accountsDataModel.items.isNotEmpty()){
            insertAndDeleteAccountUseCase(accountModel = accountsDataModel.items[0])
                .catch {
                    _homeUiState.update { state -> state.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorDialog = setErrorDialog(),
                    ) }
                }.collect {
                    getSummary(accountsDataModel = accountsDataModel)
                    getLastMoves(accountsDataModel = accountsDataModel)
                    _homeUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING, accounts = accountsDataModel) }
                }
        }
    }
    
    private fun getSummary(accountsDataModel: AccountsDataModel) = viewModelScope.launch {
        if(accountsDataModel.items.isNotEmpty()){
            getSummaryUseCase(
                accountId = accountsDataModel.items[0].id,
                url = NetworkUrl.GET_SUMMARY_ENDPOINT
            )
                .onStart {
                
                }.catch {
                
                }.collect { result ->
                    when(result) {
                        is NetworkResult.Success -> {
                            result.response.let { summary ->
                                _homeUiState.update { state ->
                                    state.copy(
                                        isLoading = StatusLoading.DISMISS_LOADING,
                                        summary = summary
                                    )
                                }
                            }
                        }
                        
                        is NetworkResult.Error -> {
                            _homeUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                            _homeUiState.update { state ->
                                state.copy(
                                    isLoading = StatusLoading.DISMISS_LOADING,
                                    errorDialog = setErrorDialog(message =
                                        result.message.ifEmpty {
                                            getString(Res.string.please_try_again_later)
                                        }
                                    )
                                )
                            }
                        }
                    }
                }
        }
    }
    
    private fun getLastMoves(accountsDataModel: AccountsDataModel) = viewModelScope.launch {
        if(accountsDataModel.items.isNotEmpty()){
            getLastMovesUseCase(
                accountId = accountsDataModel.items[0].id,
                url = NetworkUrl.GET_TRANSACTIONS_ENDPOINT
            ).onStart {
            
            }.catch {
                _homeUiState.update { state ->
                    state.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorTransactions = true
                    )
                }
            }.collect {
                    result ->
                when(result) {
                    is NetworkResult.Success -> {
                        result.response.let { transactions ->
                            _homeUiState.update { state ->
                                state.copy(
                                    isLoading = StatusLoading.DISMISS_LOADING,
                                    transactions = transactions
                                )
                            }
                        }
                    }
                    is NetworkResult.Error -> {
                        _homeUiState.update { state ->
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
    
    private suspend fun setErrorDialog(message: String? = null): ErrorDialogModel =
        ErrorDialogModel(
            title = getString(resource = Res.string.error),
            message = message ?: getString(resource = Res.string.please_try_again_later),
            primaryButtonText = getString(resource = Res.string.Accept),
        )
    
}
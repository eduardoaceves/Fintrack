/*
 * PackagesViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.packages.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.usecase.packages.ClearAndInsertPackagesUseCase
import com.uagr.kmp.course.domain.usecase.packages.GetLocalPackagesUseCase
import com.uagr.kmp.course.domain.usecase.packages.GetNetworkPackagesUseCase
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
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class PackagesViewModel(
    private val getNetworkPackagesUseCase: GetNetworkPackagesUseCase,
    private val clearAndInsertPackagesUseCase: ClearAndInsertPackagesUseCase,
    private val getLocalPackagesUseCase: GetLocalPackagesUseCase,
): ViewModel() {

    private var _packagesUiState = MutableStateFlow(PackagesUiState())
    val packagesUiState: StateFlow<PackagesUiState> = _packagesUiState.asStateFlow()

    private var _packagesUiEvent = MutableStateFlow<PackagesUiEvent>(PackagesUiEvent.Idle)
    val packagesUiEvent: StateFlow<PackagesUiEvent> = _packagesUiEvent.asStateFlow()

    init {
        getPackages()
    }

    private fun getPackages() = viewModelScope.launch {
        getNetworkPackagesUseCase(url = NetworkUrl.GET_PACKAGES_ENDPOINT)
            .onStart {
                _packagesUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
            }.catch {
                _packagesUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                _packagesUiEvent.emit(PackagesUiEvent.ShowErrorDialog(message = Res.string.please_try_again_later))
            }.collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        clearAndInsertPackages(packages = result.response.data)
                    }
                    is NetworkResult.Error -> {
                        _packagesUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                        _packagesUiEvent.emit(PackagesUiEvent.ShowErrorStringDialog(message = result.message))
                    }
                }
            }
    }

    private fun clearAndInsertPackages(packages: List<PackagesDataModel>) = viewModelScope.launch {
        clearAndInsertPackagesUseCase(packages = packages)
            .catch {
                _packagesUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                _packagesUiEvent.emit(PackagesUiEvent.ShowErrorDialog(message = Res.string.please_try_again_later))
            }.collect {
                getLocalPackages()
            }
    }

    private fun getLocalPackages() = viewModelScope.launch {
        getLocalPackagesUseCase()
            .catch {
                _packagesUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                _packagesUiEvent.emit(PackagesUiEvent.ShowErrorDialog(message = Res.string.please_try_again_later))
            }.collect { result ->
                _packagesUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING, packages = result) }
            }
    }
}

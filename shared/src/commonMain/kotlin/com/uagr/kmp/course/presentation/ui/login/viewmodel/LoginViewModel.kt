/*
 * LoginViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.login.LoginDataModel
import com.uagr.kmp.course.domain.usecase.login.LoginUseCase
import com.uagr.kmp.course.domain.usecase.login.LoginValidationResult
import com.uagr.kmp.course.domain.usecase.login.ValidateLoginFormUseCase
import com.uagr.kmp.course.domain.usecase.user.InsertUserAndDeleteUseCase
import com.uagr.kmp.course.domain.usecase.user.SaveUserTokenUseCase
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Accept
import course.shared.generated.resources.Res
import course.shared.generated.resources.email_wrong_format
import course.shared.generated.resources.empty_field
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
import kotlin.collections.copy

@KoinViewModel
class LoginViewModel(
    private val validateLoginFormUseCase: ValidateLoginFormUseCase,
    private val loginUseCase: LoginUseCase,
    private val insertUserAndDeleteUseCase: InsertUserAndDeleteUseCase,
    private val saveUserTokenUseCase: SaveUserTokenUseCase,
) : ViewModel() {

    private var _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    private var _loginUiEvent = MutableStateFlow<LoginUiEvent>(LoginUiEvent.Idle)
    val loginUiEvent: StateFlow<LoginUiEvent> = _loginUiEvent.asStateFlow()

    fun updateEmail(email: String) = viewModelScope.launch {
        if(email.length < Constants.EMAIL_LENGTH) {
            _loginUiState.update { state -> state.copy(email = email) }
        }
    }

    fun updatePassword(password: String) = viewModelScope.launch {
        if(password.length < Constants.PASSWORD_LENGTH) {
            _loginUiState.update { state -> state.copy(password = password) }
        }
    }

    fun updatePasswordVisible(passwordVisible: Boolean) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(passwordVisible = passwordVisible) }
    }

    fun validateLoginForm(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        when (validateLoginFormUseCase(
            email = email,
            password = password,
        )) {
            is LoginValidationResult.EmptyFields ->{
                loginFormErrors(
                    emailError = getString(Res.string.empty_field),
                    passwordError = getString(Res.string.empty_field)
                )
            }
            is LoginValidationResult.EmailEmpty ->{
                loginFormErrors(emailError = getString(Res.string.empty_field))
            }
            is LoginValidationResult.WrongEmailFormat -> {
                loginFormErrors(emailError = getString(Res.string.email_wrong_format))
            }
            is LoginValidationResult.PasswordEmpty -> {
                loginFormErrors(passwordError = getString(Res.string.empty_field))
            }
            else -> {
                login(email = email, password = password)
            }
        }
    }
    
    private fun loginFormErrors(
        emailError: String = "",
        passwordError: String = "",
        )
    {
        _loginUiState.update { state -> state.copy(
            emailError = emailError,
            passwordError = passwordError,
        ) }
    }

    private fun login(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        loginUseCase.login(
            url = NetworkUrl.LOGIN_ENDPOINT,
            email = email,
            password = password,
        ).onStart {
            _loginUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
        }.catch {
            _loginUiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = setErrorDialog(),
                )
            }
        }.collect { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.response.data?.let { data ->
                        insertUserAndDelete(loginData = data)
                    } ?: run {
                        _loginUiState.update { state ->
                            state.copy(
                                isLoading = StatusLoading.DISMISS_LOADING,
                                errorDialog = setErrorDialog(),
                            )
                        }
                    }
                }
                is NetworkResult.Error -> {
                    _loginUiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            errorDialog = setErrorDialog(),
                        )
                    }
                }
            }
        }
    }

    private fun insertUserAndDelete(loginData: LoginDataModel) = viewModelScope.launch {
        insertUserAndDeleteUseCase(user = loginData.user)
            .catch {
                _loginUiState.update { state ->
                    state.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorDialog = setErrorDialog(),
                    )
                }
            }.collect {
                saveUserToken(loginData = loginData)
            }
    }

    private fun saveUserToken(loginData: LoginDataModel) = viewModelScope.launch {
        saveUserTokenUseCase(token = loginData.tokens)
            .catch {
                _loginUiState.update { state ->
                    state.copy(
                        isLoading = StatusLoading.DISMISS_LOADING,
                        errorDialog = setErrorDialog(),
                    )
                }
        }.collect {
            _loginUiEvent.emit(LoginUiEvent.LoginSuccess)
        }
    }

    private suspend fun setErrorDialog(message: String? = null): ErrorDialogModel =
        ErrorDialogModel(
            title = getString(resource = Res.string.error),
            message = message ?: getString(resource = Res.string.please_try_again_later),
            primaryButtonText = getString(resource = Res.string.Accept),
        )

    fun dismissErrorDialog() = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(errorDialog = null) }
    }

    fun resetUiEvent() = viewModelScope.launch  {
        _loginUiEvent.value = LoginUiEvent.Idle
    }
    
}

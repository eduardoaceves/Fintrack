/*
 * RegisterViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.register.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.domain.model.user.TokenDataModel
import com.uagr.kmp.course.domain.model.user.UserTokensModel
import com.uagr.kmp.course.domain.usecase.register.RegisterUserUseCase
import com.uagr.kmp.course.domain.usecase.register.ValidateRegisterFormResult
import com.uagr.kmp.course.domain.usecase.register.ValidateRegisterFormUseCase
import com.uagr.kmp.course.domain.usecase.user.InsertUserAndDeleteUseCase
import com.uagr.kmp.course.domain.usecase.user.SaveUserTokenUseCase
import com.uagr.kmp.course.presentation.ui.login.viewmodel.LoginUiEvent
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
import course.shared.generated.resources.register_sucess
import course.shared.generated.resources.register_wrong_passwords
import course.shared.generated.resources.success_title
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
class RegisterViewModel(
    private val validateRegisterFormUseCase: ValidateRegisterFormUseCase,
    private val insertUserUseCase: InsertUserAndDeleteUseCase,
    private val saveUserTokenUseCase: SaveUserTokenUseCase,
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {
    
    private var _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()
    
    private var _registerUiEvent = MutableStateFlow<RegisterUiEvent>(RegisterUiEvent.Idle)
    val registerUiEvent: StateFlow<RegisterUiEvent> = _registerUiEvent.asStateFlow()
    
    fun onNameChanged(name : String) = viewModelScope.launch {
        if(name.length < Constants.NAME_LENGTH)
            _registerUiState.update { state -> state.copy(name = name) }
    }
    
    fun onEmailChanged(email : String) = viewModelScope.launch {
        if(email.length < Constants.EMAIL_LENGTH)
            _registerUiState.update { state -> state.copy(email = email) }
    }
    
    fun onPasswordChanged(password : String) = viewModelScope.launch {
        if(password.length < Constants.PASSWORD_LENGTH)
            _registerUiState.update { state -> state.copy(password = password) }
    }
    
    fun onConfirmPasswordChanged(confirmPassword : String) = viewModelScope.launch {
        if(confirmPassword.length < Constants.PASSWORD_LENGTH)
            _registerUiState.update { state -> state.copy(confirmPassword = confirmPassword) }
    }
    
    fun onPasswordVisibilityChanged(isVisible : Boolean) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(passwordVisible = isVisible) }
    }
    
    fun onConfirmPasswordVisibilityChanged(isVisible : Boolean) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(confirmPasswordVisible = isVisible) }
    }
    
    fun validateRegisterForm(
        name : String,
        email : String,
        password : String,
        confirmPassword : String,
    ) = viewModelScope.launch {
        when(validateRegisterFormUseCase(
            name = name,
            email = email,
            password = password,
            confirmPassword = confirmPassword
        )){
            is ValidateRegisterFormResult.EmptyFields -> {
                registerFormErrors(
                    nameError = getString(Res.string.empty_field),
                    emailError = getString(Res.string.empty_field),
                    passwordError = getString(Res.string.empty_field),
                    confirmPasswordError = getString(Res.string.empty_field)
                )
            }
            is ValidateRegisterFormResult.NameEmpty -> {
                registerFormErrors(nameError = getString(Res.string.empty_field))
            }
            is ValidateRegisterFormResult.EmailEmpty -> {
                registerFormErrors(emailError = getString(Res.string.empty_field))
            }
            is ValidateRegisterFormResult.WrongEmailFormat -> {
                registerFormErrors(emailError = getString(Res.string.email_wrong_format))
            }
            is ValidateRegisterFormResult.PasswordEmpty -> {
                registerFormErrors(passwordError = getString(Res.string.empty_field))
            }
            is ValidateRegisterFormResult.ConfirmPasswordEmpty -> {
                registerFormErrors(confirmPasswordError = getString(Res.string.empty_field))
            }
            is ValidateRegisterFormResult.WrongPasswords -> {
                registerFormErrors(
                    passwordError = getString(Res.string.register_wrong_passwords),
                    confirmPasswordError = getString(Res.string.register_wrong_passwords)
                )
            }
            is ValidateRegisterFormResult.Success -> {
                registerFormErrors()
                registerUser(
                    name = name,
                    email = email,
                    password = password
                )
            }
        }
    }
    
    private fun registerUser(
        name : String,
        email : String,
        password : String
    ) = viewModelScope.launch{
        registerUserUseCase.registerUser(
            url = NetworkUrl.REGISTER_ENDPOINT,
            name = name,
            email = email,
            password = password
        ).onStart {
            _registerUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING)}
        }.catch {
            _registerUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING, errorDialog = setErrorDialog()) }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    insertUser(registerDataModel = result.response)
                }
                is NetworkResult.Error -> {
                    _registerUiState.update { state ->
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
    
    private fun insertUser(registerDataModel: RegisterDataModel) = viewModelScope.launch{
        insertUserUseCase(
            user = registerDataModel.user
        ).catch {
            _registerUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING, errorDialog = setErrorDialog())
            }
        }.collect {
            saveUserToken(tokenData = registerDataModel.tokens)
        }
    }
    
    private fun saveUserToken(tokenData : TokenDataModel?) = viewModelScope.launch{
        saveUserTokenUseCase(
            token = tokenData
        ).catch {
            _registerUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING, errorDialog = setErrorDialog()) }
        }.collect {
            _registerUiState.update { state -> state.copy(
                isLoading = StatusLoading.DISMISS_LOADING ,
                errorDialog = setErrorDialog(
                    title = getString(Res.string.success_title),
                    message = getString(Res.string.register_sucess),
                    operationSuccess = true,
                ))
            }
        }
    }
    
    private fun registerFormErrors(
        nameError: String = "",
        emailError: String = "",
        passwordError: String = "",
        confirmPasswordError: String = "")
    {
        _registerUiState.update { state -> state.copy(
            nameError = nameError,
            emailError = emailError,
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError
        ) }
    }
    
    suspend fun setErrorDialog(
        title : String? = null,
        message: String? = null,
        operationSuccess : Boolean? = null): ErrorDialogModel =
        ErrorDialogModel(
            title = title ?: getString(resource = Res.string.error),
            message = message ?: getString(resource = Res.string.please_try_again_later),
            primaryButtonText = getString(resource = Res.string.Accept),
            operationSuccess = operationSuccess ?: false
        )
    
    fun dismissErrorDialog() = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(errorDialog = null) }
    }
    
    fun registerSuccess() = viewModelScope.launch {
        _registerUiEvent.emit(value = RegisterUiEvent.RegisterSuccess)
    }
    
    fun resetUIEvent() = viewModelScope.launch {
        _registerUiEvent.value = RegisterUiEvent.Idle
    }
    
    
}
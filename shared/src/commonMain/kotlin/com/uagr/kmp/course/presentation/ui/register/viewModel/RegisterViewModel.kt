package com.uagr.kmp.course.presentation.ui.register.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.usecase.register.ValidateRegisterFormResult
import com.uagr.kmp.course.domain.usecase.register.ValidateRegisterFormUseCase
import com.uagr.kmp.course.utils.constant.Constants
import course.shared.generated.resources.Res
import course.shared.generated.resources.email_wrong_format
import course.shared.generated.resources.empty_field
import course.shared.generated.resources.empty_value
import course.shared.generated.resources.register_wrong_passwords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class RegisterViewModel(
    private val validateRegisterFormUseCase: ValidateRegisterFormUseCase,
) : ViewModel() {
    
    private var _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()
    
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
    
}
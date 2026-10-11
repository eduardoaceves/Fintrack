/*
 * RegisterScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.register.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.login.ui.LoginScreenContainer
import com.uagr.kmp.course.presentation.ui.register.viewModel.RegisterUiEvent
import com.uagr.kmp.course.presentation.ui.register.viewModel.RegisterViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    onRegisterSuccess: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    
    val registerUiState by viewModel.registerUiState.collectAsStateWithLifecycle()
    
    viewModel.registerUiEvent.CollectWithLifecycle{ event ->
        when(event){
            is RegisterUiEvent.Idle -> {}
            is RegisterUiEvent.RegisterSuccess -> {
                viewModel.resetUIEvent()
                onRegisterSuccess()
            }
        }
    }
    
    SafeScreenContainer {
      RegisterContainer(
          onBackClick = {
              onBackClick()
          },
          name = registerUiState.name,
          nameError = registerUiState.nameError,
          onNameChange = { name ->
              viewModel.onTextChanged(
                  name = name,
                  email = registerUiState.email,
                  password = registerUiState.password,
                  confirmPassword = registerUiState.confirmPassword
              )
          },
          email = registerUiState.email,
          emailError = registerUiState.emailError,
          onEmailChange = { email ->
              viewModel.onTextChanged(
                  name = registerUiState.name,
                  email = email,
                  password = registerUiState.password,
                  confirmPassword = registerUiState.confirmPassword
              )
          },
          password = registerUiState.password,
          passwordError = registerUiState.passwordError,
          onPasswordChange = { password ->
              viewModel.onTextChanged(
                  name = registerUiState.name,
                  email = registerUiState.email,
                  password = password,
                  confirmPassword = registerUiState.confirmPassword
              )
          },
          passwordVisible = registerUiState.passwordVisible,
          onPasswordVisibleChange =  { isVisible ->
              viewModel.onPasswordVisibilityChanged(isVisible = isVisible)
          },
          confirmPassword = registerUiState.confirmPassword,
          confirmPasswordError = registerUiState.confirmPasswordError,
          onConfirmPasswordChange = { confirmPassword ->
              viewModel.onTextChanged(
                  name = registerUiState.name,
                  email = registerUiState.email,
                  password = registerUiState.password,
                  confirmPassword = confirmPassword
              )
          },
          confirmPasswordVisible = registerUiState.confirmPasswordVisible,
          onConfirmPasswordVisibleChange = { isVisible ->
              viewModel.onConfirmPasswordVisibilityChanged(isVisible = isVisible)
          },
          onRegisterClick = {
                viewModel.validateRegisterForm(
                    name = registerUiState.name,
                    email = registerUiState.email,
                    password = registerUiState.password,
                    confirmPassword = registerUiState.confirmPassword
                )
          }
      )
        Loader(isLoading = registerUiState.isLoading)
        DialogCustom(
            errorDialog = registerUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                viewModel.dismissErrorDialog()
                registerUiState.errorDialog?.operationSuccess.let { success ->
                    if(success == true){
                        viewModel.registerSuccess()
                    }
                }
            },
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun RegisterScreenPreview() {
    SafeScreenContainerTest {
        LoginScreenContainer()
    }
}
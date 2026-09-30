/*
 * LoginScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.component.transactions.LazyColumnExample
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.login.viewmodel.LoginUiEvent
import com.uagr.kmp.course.presentation.ui.login.viewmodel.LoginViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import com.uagr.kmp.course.utils.text.compareDates
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
) {
    val loginUiState by viewModel.loginUiState.collectAsStateWithLifecycle()
    
    viewModel.loginUiEvent.CollectWithLifecycle { event ->
        when (event) {
            is LoginUiEvent.Idle -> {}
            is LoginUiEvent.LoginSuccess -> {
                viewModel.resetUiEvent()
                onLoginSuccess()
            }
        }
    }

    SafeScreenContainer(
        modifier = Modifier.background(color = AppTheme.colors.backgrounds.canvas)
    ) {
        //LazyColumnExample()
        LoginContainer(
            email = loginUiState.email,
            emailError = loginUiState.emailError,
            onEmailChanged = { email ->
                viewModel.updateEmail(email =email)
            },
            password = loginUiState.password,
            passwordError =  loginUiState.passwordError,
            onPasswordChanged = { password ->
                viewModel.updatePassword(password = password)
            },
            passwordVisible = loginUiState.passwordVisible,
            onPasswordVisibilityChanged = { passwordVisible ->
                viewModel.updatePasswordVisible(passwordVisible = passwordVisible)
            },
            onLoginClick = {
                viewModel.validateLoginForm(
                    email = loginUiState.email,
                    password = loginUiState.password
                )
            },
            onHomeClick = {
                onHomeClick()
            },
            onCreateAccountClick = {
                onCreateAccountClick()
            },
        )
        Loader(isLoading = loginUiState.isLoading)
        DialogCustom(
            errorDialog = loginUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                viewModel.dismissErrorDialog()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    SafeScreenContainerTest {
        LoginContainer()
    }
}

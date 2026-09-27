package com.uagr.kmp.course.presentation.ui.register.viewModel

import com.uagr.kmp.course.presentation.ui.login.viewmodel.LoginUiEvent

sealed class RegisterUiEvent {
    internal data object Idle : RegisterUiEvent()
    data object RegisterSuccess : RegisterUiEvent()
}
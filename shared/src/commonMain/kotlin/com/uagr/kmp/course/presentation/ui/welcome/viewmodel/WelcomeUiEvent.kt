package com.kmp.presentation.welcome.viewmodel

sealed class WelcomeUiEvent {
    internal data object Idle : WelcomeUiEvent()
    data object ShowVersionInfoDialog : WelcomeUiEvent()
}
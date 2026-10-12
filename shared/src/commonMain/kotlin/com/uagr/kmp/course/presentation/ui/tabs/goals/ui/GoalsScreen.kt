package com.uagr.kmp.course.presentation.ui.tabs.goals.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.tabs.goals.viewmodel.GoalsUiEvent
import com.uagr.kmp.course.presentation.ui.tabs.goals.viewmodel.GoalsViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GoalsScreen(
    viewModel : GoalsViewModel = koinViewModel(),
    closeSession : () -> Unit = {},
) {
    
    val goalsUiState by viewModel.goalsUiState.collectAsStateWithLifecycle()
    
    viewModel.goalsUiEvent.CollectWithLifecycle { event ->
        when (event) {
            GoalsUiEvent.Idle -> {}
            GoalsUiEvent.CloseSessionSuccess -> {
                closeSession()
                viewModel.resetUiEvent()
            }
        }
    }
    
    SafeScreenContainer(
        modifier = Modifier.background(color = AppTheme.colors.backgrounds.canvas)
    ) {
        GoalsScreenContainer(
            closeSession = {
                viewModel.closeSession()
            }
        )
        Loader(isLoading = goalsUiState.isLoading)
        DialogCustom(
            errorDialog = goalsUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
            
            }
        )
    }
}
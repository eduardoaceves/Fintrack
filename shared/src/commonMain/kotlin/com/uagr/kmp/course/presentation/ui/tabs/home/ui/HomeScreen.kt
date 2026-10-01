package com.uagr.kmp.course.presentation.ui.tabs.home.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel.HomeUiEvent
import com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel.HomeViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel : HomeViewModel = koinViewModel(),
    onEmptyAccounts : () -> Unit = {},
    gotoSeeAll : () -> Unit = {},
){
    
    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    
    viewModel.homeUiEvent.CollectWithLifecycle { event ->
        when (event) {
            is HomeUiEvent.Idle -> {}
            is HomeUiEvent.AccountsSuccess-> {
                //viewModel.resetUiEvent()
                //onLoginSuccess()
            }
        }
    }
    
    SafeScreenContainer(
        modifier = Modifier.background(color = AppTheme.colors.backgrounds.canvas)
    ) {
        HomeScreenContainer(
            accounts = homeUiState.accounts,
            summary =  homeUiState.summary,
            transactions = homeUiState.transactions,
            transactionError = homeUiState.errorTransactions,
            gotoSeeAll = gotoSeeAll
        )
        DialogCustom(
            errorDialog = homeUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                onEmptyAccounts()
            },
        )
    }
    
    
    
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SafeScreenContainerTest {
        HomeScreenContainer()
    }
}
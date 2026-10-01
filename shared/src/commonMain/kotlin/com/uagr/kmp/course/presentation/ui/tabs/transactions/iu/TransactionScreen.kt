package com.uagr.kmp.course.presentation.ui.tabs.transactions.iu

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.tabs.home.ui.HomeScreenContainer
import com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel.HomeUiEvent
import com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel.HomeViewModel
import com.uagr.kmp.course.presentation.ui.tabs.transactions.viewmodel.TransactionViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TransactionScreen(
    viewModel : TransactionViewModel = koinViewModel(),
){
    val transactionUiState by viewModel.transactionsUiState.collectAsStateWithLifecycle()
    
    SafeScreenContainer(
        modifier = Modifier.background(color = AppTheme.colors.backgrounds.canvas)
    ) {
        TransactionsScreenContainer(
            transactions = transactionUiState.transactions,
            transactionError = transactionUiState.errorTransactions,
            searchText = transactionUiState.searchText,
            isSearching = transactionUiState.isSearching,
            onValueChange = viewModel::onSearchTextChange
        )
        Loader(isLoading = transactionUiState.isLoading)
        DialogCustom(
            errorDialog = transactionUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SafeScreenContainerTest {
        TransactionScreen()
    }
}
/*
 * TransactionsScreenContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.transactions.iu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.presentation.component.buton.TransactionButton
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.searchbAr.SimpleSearchBarExample
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.text.getTransactionTitle
import course.shared.generated.resources.Res
import course.shared.generated.resources.server_error
import course.shared.generated.resources.transactions_filter_all
import course.shared.generated.resources.transactions_filter_expends
import course.shared.generated.resources.transactions_filter_incomes
import course.shared.generated.resources.transactions_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionsScreenContainer(
    transactions : TransactionsDataModel? = null,
    transactionError : Boolean = false,
    isSearching : Boolean = false,
    searchText : String = "",
    onValueChange : (String) -> Unit = {},
    filterTransactions : (String) -> Unit = { _ -> }
){
    
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    
    Column(
        modifier = Modifier.padding(all = Dimens.padding16)
            .background(color = AppTheme.colors.backgrounds.canvas)
            .fillMaxSize()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        TextNormalBold(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSize28sp,
            color = AppTheme.colors.text.black,
            text = getTransactionTitle(),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height8))
        TextNormal(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSizeNormal,
            color = AppTheme.colors.text.gray,
            text = stringResource(Res.string.transactions_title)
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height20))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start)
        {
            TransactionButton(
                backgroundButton = AppTheme.colors.backgrounds.blue,
                textColor = AppTheme.colors.backgrounds.white,
                width = Dimens.width100,
                text = stringResource(Res.string.transactions_filter_all),
                fontSize = Dimens.textSize11sp,
                onClick = {
                    transactions?.let {
                        filterTransactions(Constants.TRANSACTION_ALL)
                    }
                }
            )
            Spacer(Modifier.width(Dimens.padding10))
            TransactionButton(
                backgroundButton = AppTheme.colors.backgrounds.greenActive,
                textColor = AppTheme.colors.backgrounds.white,
                width = Dimens.width100,
                text = stringResource(Res.string.transactions_filter_incomes),
                fontSize = Dimens.textSize11sp,
                onClick = {
                    transactions?.let {
                        filterTransactions(Constants.TRANSACTION_INCOME)
                    }
                }
            )
            Spacer(Modifier.width(Dimens.padding10))
            TransactionButton(
                backgroundButton = AppTheme.colors.backgrounds.redActive,
                textColor = AppTheme.colors.backgrounds.white,
                width = Dimens.width100,
                text = stringResource(Res.string.transactions_filter_expends),
                fontSize = Dimens.textSize11sp,
                onClick = {
                    transactions?.let {
                        filterTransactions(Constants.TRANSACTION_EXPEND)
                    }
                }
            )
        }
        if(!transactionError){
            Spacer(Modifier.fillMaxWidth().height(Dimens.height20))
            SimpleSearchBarExample(
                transactions = transactions,
                searchText = searchText,
                isSearching = isSearching,
                onValueChange = onValueChange
            )
            Spacer(Modifier.fillMaxWidth().height(Dimens.height60))
        } else {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height128))
                Image(
                    modifier = Modifier.size(Dimens.height200),
                    painter = painterResource(Res.drawable.server_error),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().weight(2f))
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionsScreenContainerPreview() {
    SafeScreenContainerTest {
        TransactionsScreenContainer()
    }
}
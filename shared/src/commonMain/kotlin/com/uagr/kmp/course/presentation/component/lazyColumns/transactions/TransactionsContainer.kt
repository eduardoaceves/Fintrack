/*
 * TransactionsContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.lazyColumns.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.TransactionsDataModelMock
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.server_error
import org.jetbrains.compose.resources.painterResource

@Composable
fun TransactionsContainer(
    transactions : TransactionsDataModel? = null,
    transactionError : Boolean = false,
){
    Column(modifier = Modifier.fillMaxWidth()) {
        if(!transactionError){
            transactions?.let {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().height(Dimens.height400),
                    flingBehavior = ScrollableDefaults.flingBehavior()
                )
                {
                    val sortedItems = transactions.items.sortedByDescending { it.transactionDate }
                    val groupedItems = sortedItems.groupBy { it.transactionDate }
                    groupedItems.forEach { (transactionDate, transactions) ->
                        stickyHeader {
                            TextMedium(
                                //text = getTransactionDate(transactionDate),
                                text = transactionDate,
                                fontSize = Dimens.textSize13sp,
                                textAlign = TextAlign.Start,
                                color = AppTheme.colors.text.gray,
                                modifier = Modifier.fillMaxWidth()
                                    .offset(x = -Dimens.padding8)
                                    .background(color = AppTheme.colors.backgrounds.canvas)
                                    .padding(Dimens.padding8)
                            )
                        }
                        items(
                            items = transactions,
                            itemContent = {
                                TransactionItem(transaction = it)
                            }
                        )
                    }
                    
                }
            } ?: run {
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(top = Dimens.height20),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                }
            }
        } else {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.size(Dimens.height128),
                    painter = painterResource(Res.drawable.server_error),
                    contentDescription = null
                )
            }
        }
        
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun LastMovementsPreview() {
    SafeScreenContainerTest {
        TransactionsContainer(transactions = TransactionsDataModelMock)
    }
}


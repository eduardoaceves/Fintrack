/*
 * Transactions.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.TransactionsDataModelMock
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextMediumBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_last_moves
import course.shared.generated.resources.home_see_all
import course.shared.generated.resources.server_error
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun Transactions(
    transactions : TransactionsDataModel? = null,
    transactionError : Boolean = false
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextMedium(
                modifier = Modifier.fillMaxWidth().weight(.6f),
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSize18sp,
                color = AppTheme.colors.text.black,
                text = stringResource(Res.string.home_last_moves)
            )
            TextMediumBold(
                modifier = Modifier.fillMaxWidth().weight(.4f),
                textAlign = TextAlign.End,
                fontSize = Dimens.textSize12sp,
                color = AppTheme.colors.text.blue,
                text = stringResource(Res.string.home_see_all)
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height18))
        
        if(!transactionError){
            transactions?.let {
                /*LazyColumn(modifier = Modifier.fillMaxWidth().height(Dimens.height200))
                {
                    val group = transactions.items.groupBy { it.transactionDate }
                    group.forEach { (transactionDate, transactions) ->
                        stickyHeader {
                            TextMediumBold(
                                text = transactionDate,
                                color = AppTheme.colors.text.gray,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        items(
                            items = transactions,
                            itemContent = {
                                TransactionItem(transaction = it)
                                //ListItem(person = it, selectedPerson = selectedPerson)
                            }
                        )
                    }
                    
                }*/
                LazyColumn(modifier = Modifier.fillMaxWidth().height(Dimens.height200))
                {
                    items(count = transactions.items.size) { index ->
                        TransactionItem(transaction = transactions.items[index])
                    }
                }
            } ?: run {
                Column(modifier = Modifier.fillMaxWidth(),
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


@Preview(showBackground = true)
@Composable
fun LastMovementsPreview() {
    SafeScreenContainerTest {
        Transactions(transactions = TransactionsDataModelMock)
    }
}


/*
 * Transactions.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.transations.TransactionItemModel
import com.uagr.kmp.course.presentation.component.card.SimpleCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.transactionDataMock
import com.uagr.kmp.course.presentation.component.text.TextMediumBold
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.utils.constant.Constants
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_dot
import org.jetbrains.compose.resources.painterResource

@Composable
fun TransactionItem(
    transaction: TransactionItemModel
){
    
    val activeColor =
        if(transaction.type.trim() == Constants.TRANSACTION_EXPEND)
        AppTheme.colors.backgrounds.redActive
    else
        AppTheme.colors.backgrounds.greenActive
    
    val symbol =
        if(transaction.type.trim() == Constants.TRANSACTION_EXPEND)
            "-$"
        else
            "+$"
    
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            SimpleCard(
                paddingColumn = Dimens.padding2,
                cardBackgroundColor =
                    if(transaction.type.trim() == Constants.TRANSACTION_EXPEND)
                        AppTheme.colors.backgrounds.red
                    else
                        AppTheme.colors.backgrounds.green,
                modifierCard = Modifier.size(Dimens.height42),
                modifierColumn = Modifier.weight(1f)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Icon(
                        modifier = Modifier.size(Dimens.height30),
                        painter = painterResource(Res.drawable.ic_dot),
                        tint = activeColor,
                        contentDescription = null
                    )
                }
            }
            Column(
                modifier = Modifier.weight(3f)
                    .padding(start = Dimens.padding16),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                TextMediumBold(
                    modifier = Modifier,
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize14sp,
                    color = AppTheme.colors.text.black,
                    text = transaction.description
                )
                TextNormal(
                    modifier = Modifier
                        .padding(top = Dimens.height4),
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize12sp,
                    color = AppTheme.colors.text.gray,
                    text = transaction.notes
                )
            }
            TextMediumBold(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End,
                fontSize = Dimens.textSize14sp,
                color = activeColor,
                text = symbol+transaction.amount
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height16))
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionItemPreview() {
    SafeScreenContainerTest {
        TransactionItem(
            transaction = transactionDataMock
        )
    }
}
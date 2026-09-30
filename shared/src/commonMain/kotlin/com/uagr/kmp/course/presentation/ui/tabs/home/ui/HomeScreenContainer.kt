/*
 * HomeScreenContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.presentation.component.card.BalanceCard
import com.uagr.kmp.course.presentation.component.card.SimpleCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.component.text.TextSmall
import com.uagr.kmp.course.presentation.component.transactions.LazyColumnExample
import com.uagr.kmp.course.presentation.component.transactions.Transactions
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_bills
import course.shared.generated.resources.home_down_percentage
import course.shared.generated.resources.home_hello
import course.shared.generated.resources.home_income
import course.shared.generated.resources.home_month
import course.shared.generated.resources.home_saving
import course.shared.generated.resources.home_title
import course.shared.generated.resources.home_up_percentage
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreenContainer(
    accounts : AccountsDataModel? = null,
    summary : SummaryDataModel? = null,
    transactions : TransactionsDataModel? = null,
    transactionError : Boolean = false
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
        //Column(modifier = Modifier.padding(all = Dimens.padding16)) {
            Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
            TextNormal(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSizeNormal,
                color = AppTheme.colors.text.gray,
                text = stringResource(Res.string.home_hello)
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height8))
            TextNormalBold(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSize28sp,
                color = AppTheme.colors.text.black,
                text = stringResource(Res.string.home_title),
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height20))
            accounts?.let {
                LazyRow(modifier = Modifier.fillMaxWidth())
                {
                    items(count = accounts.items.size) { index ->
                        SimpleCard(
                            modifierCard = Modifier.fillParentMaxWidth(),
                            cardBackgroundColor = AppTheme.colors.primary
                        ) {
                            TextNormal(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = Dimens.textSizeNormal,
                                color = AppTheme.colors.text.white,
                                text = accounts.items[index].name,
                            )
                            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height13))
                            TextNormalBold(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = Dimens.textSizeBig,
                                color = AppTheme.colors.text.white,
                                text = "$" + summary?.net,
                            )
                            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height21))
                            Row(modifier = Modifier.fillMaxWidth())
                            {
                                Column(modifier = Modifier.weight(1f)) {
                                    TextSmall(
                                        textAlign = TextAlign.Start,
                                        fontSize = Dimens.textSize12sp,
                                        color = AppTheme.colors.text.white,
                                        text = stringResource(Res.string.home_income),
                                    )
                                    Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height7))
                                    TextMedium(
                                        textAlign = TextAlign.Start,
                                        fontSize = Dimens.textSize14sp,
                                        color = AppTheme.colors.text.white,
                                        text = "+$"+summary?.income
                                    )
                                }
                                Column(modifier = Modifier.weight(1f)) {
                                    TextSmall(
                                        textAlign = TextAlign.Start,
                                        fontSize = Dimens.textSize12sp,
                                        color = AppTheme.colors.text.white,
                                        text = stringResource(Res.string.home_bills),
                                    )
                                    Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height7))
                                    TextMedium(
                                        textAlign = TextAlign.Start,
                                        fontSize = Dimens.textSize14sp,
                                        color = AppTheme.colors.text.white,
                                        text = "-$"+summary?.expenses.orEmpty()
                                    )
                                }
                            }
                        }
                    }
                }
            } ?: run {
                CircularProgressIndicator(
                    color = AppTheme.colors.primary,
                )
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height28))
            TextNormalBold(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSize18sp,
                color = AppTheme.colors.text.black,
                text = stringResource(Res.string.home_month)
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height14))
            Row(modifier = Modifier.fillMaxWidth()) {
                BalanceCard(
                    modifier = Modifier.weight(1f),
                    title = stringResource(Res.string.home_bills),
                    amount = "$"+summary?.expenses.orEmpty(),
                    percentage = stringResource(Res.string.home_down_percentage),
                )
                Spacer(modifier = Modifier.fillMaxWidth().weight(.2f))
                BalanceCard(
                    modifier = Modifier.weight(1f),
                    title = stringResource(Res.string.home_saving),
                    amount = "$"+summary?.income.orEmpty(),
                    percentage = stringResource(Res.string.home_up_percentage),
                )
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height20))
            LazyColumnExample()
        /*Transactions(
                transactions = transactions,
                transactionError = transactionError
            )*/
            Spacer(modifier = Modifier.fillMaxWidth().weight(2f))
        //}
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContainerPreview() {
    SafeScreenContainerTest {
        HomeScreenContainer()
    }
}
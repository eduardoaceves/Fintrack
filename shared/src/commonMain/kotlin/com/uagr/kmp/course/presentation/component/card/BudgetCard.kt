/*
 * BudgetCard.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.budgetSummaryDataMock
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.budget_month_budget
import course.shared.generated.resources.budget_used
import org.jetbrains.compose.resources.stringResource

@Composable
fun BudgetCard(
    title : String? = stringResource(Res.string.budget_month_budget),
    budgetSummary: BudgetSummaryModel? = null,
    modifier: Modifier = Modifier
){
    budgetSummary?.let{
        SimpleCard(
            modifierCard = modifier,
            cardBackgroundColor = AppTheme.colors.backgrounds.white
        ) {
            Column(modifier = Modifier) {
                TextMedium(
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize13sp,
                    color = AppTheme.colors.text.gray,
                    text = title.orEmpty()
                )
                Spacer(modifier = Modifier.height(Dimens.height6))
                TextNormalBold(
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize28sp,
                    color = AppTheme.colors.text.black,
                    text = "$"+budgetSummary.budget
                )
                Spacer(modifier = Modifier.height(Dimens.height6))
                TextNormalBold(
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize12sp,
                    color = AppTheme.colors.text.green,
                    text = stringResource(Res.string.budget_used) + " $"+budgetSummary.spent + " - " + budgetSummary.percentage+"%"
                )
            }
        }
    } ?: run{
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun BudgetCardPreview() {
    SafeScreenContainerTest {
        BudgetCard(
            modifier = Modifier,
            title = stringResource(Res.string.budget_month_budget),
            budgetSummary = budgetSummaryDataMock,
        )
    }
}

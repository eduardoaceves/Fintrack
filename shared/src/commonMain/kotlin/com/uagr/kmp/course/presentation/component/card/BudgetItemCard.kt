/*
 * BudgetCard.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.budgets.BudgetsModelItem
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.budgetsModelItem
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.utils.text.getTransactionTitle

@Composable
fun BudgetItemCard(
    budget: BudgetsModelItem? = null,
    modifier: Modifier = Modifier
){
    budget?.let{
        SimpleCard(
            modifierCard = modifier,
            cardBackgroundColor = AppTheme.colors.backgrounds.white
        ) {
            Column(modifier = Modifier) {
                TextNormalBold(
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize14sp,
                    color = AppTheme.colors.text.black,
                    text = getTransactionTitle(categoryID = budget.category_id)
                )
                Spacer(modifier = Modifier.height(Dimens.height6))
                TextMedium(
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSize11sp,
                    color = AppTheme.colors.text.gray,
                    text = "$"+budget.amount
                )
                Spacer(modifier = Modifier.height(Dimens.height6))
            }
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun BudgetItemCardPreview() {
    SafeScreenContainerTest {
        BudgetItemCard(
            modifier = Modifier,
            budget = budgetsModelItem
        )
    }
}

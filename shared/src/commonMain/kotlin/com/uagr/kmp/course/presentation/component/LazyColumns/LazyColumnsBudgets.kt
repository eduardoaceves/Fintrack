/*
 * LazyColumnsBudgets.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.LazyColumns

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.presentation.component.card.BudgetItemCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.budgetsDataMock
import com.uagr.kmp.course.presentation.theme.Dimens

@Composable
fun LazyColumnsBudgets(
    budgets: BudgetsModel? = null,
    modifier: Modifier = Modifier
){
    budgets?.let{
        LazyColumn(
            modifier = Modifier
                .height(Dimens.height500)
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(
                space = Dimens.padding16,
                alignment = Alignment.CenterVertically,
            ),
        ) {
            items(count = budgets.data.size) { index ->
                budgets.data[index].let { budget ->
                    BudgetItemCard(
                        budget = budget,
                    )
                }
            }
        }
    } ?: run {
        /*Column(modifier = Modifier.fillMaxWidth().height(Dimens.height30),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height20))
            CircularProgressIndicator()
        }*/
        CircularProgressIndicator()
    }
    
}

@Preview(showBackground = true)
@Composable
fun LazyColumnsBudgetsPreview() {
    SafeScreenContainerTest {
        LazyColumnsBudgets(
            modifier = Modifier,
            budgets = budgetsDataMock
        )
    }
}

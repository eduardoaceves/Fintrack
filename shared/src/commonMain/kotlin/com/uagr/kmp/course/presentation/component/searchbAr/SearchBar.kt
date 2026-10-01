/*
 * SearchBar.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.searchbAr

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.transations.TransactionItemModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldSearch
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.transactions.TransactionItem
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.utils.constant.Constants
import course.shared.generated.resources.Res
import course.shared.generated.resources.transactions_filter_searc
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBarExample(
    transactions : TransactionsDataModel? = null,
    isSearching : Boolean = false,
    searchText : String = "",
    onValueChange : (String) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()){
        
        
        TextFieldSearch(
            text = if(searchText == Constants.TRANSACTION_EXPEND || searchText == Constants.TRANSACTION_INCOME) "" else searchText,
            onTextChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            labelColor = Color.Black,
            label = stringResource(Res.string.transactions_filter_searc),
            placeholderColor = Color.Black,
            placeholder = stringResource(Res.string.transactions_filter_searc),
            keyboardType = KeyboardType.Password,
            capitalization = KeyboardCapitalization.None,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height8))
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.height500))
        {
            transactions.let {
                val filter = if(searchText.isEmpty()){
                   transactions?.items
                } else {
                    transactions?.items?.filter {
                        it.description.lowercase().contains(searchText.lowercase(), ignoreCase = false) ||
                                it.notes.lowercase().contains(searchText.lowercase(), ignoreCase = false) ||
                                it.type.lowercase().contains(searchText.lowercase(), ignoreCase = false)
                    }
                }
            
                val sortedItems = filter?.sortedByDescending { it.transactionDate }
                val groupedItems = sortedItems?.groupBy { it.transactionDate }
                groupedItems?.forEach { (transactionDate, transactions) ->
                    stickyHeader {
                        TextMedium(
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
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SafeScreenContainerTest {
        SimpleSearchBarExample()
    }
}
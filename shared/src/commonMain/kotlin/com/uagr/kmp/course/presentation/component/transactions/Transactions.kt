/*
 * Transactions.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
import io.ktor.http.headers
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
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().height(Dimens.height200),
                    flingBehavior = ScrollableDefaults.flingBehavior()
                )
                {
                    val group = transactions.items.groupBy { it.transactionDate }
                    group.forEach { (transactionDate, transactions) ->
                        headers {
                        
                        }
                        stickyHeader {
                            TextMedium(
                                text = transactionDate,
                                fontSize = Dimens.textSize13sp,
                                textAlign = TextAlign.Start,
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
                    
                }
                /*LazyColumn(modifier = Modifier.fillMaxWidth().height(Dimens.height200))
                {
                    items(count = transactions.items.size) { index ->
                        TransactionItem(transaction = transactions.items[index])
                    }
                }*/
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

data class Item(val title: String, val description: String, val index: Int = 0)

@Composable
fun LazyColumnExample() {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            text = "Mi lista de ítems",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth().height(Dimens.height200),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                val myList = (1..50).map {
                    Item(
                        title = "Ítem ${it}",
                        description = "Descripción del ítem ${it}. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                        index = it
                    )
                }.groupBy { (it.index - 1) / 10 + 1 }
                
                myList.entries.forEach { entry ->
                    stickyHeader {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.LightGray)
                                .padding(6.dp)
                        ) {
                            Text(
                                text = "Del ${entry.key * 10 - 9} al ${entry.key * 10}",
                                style = MaterialTheme.typography.titleMedium,
                            )
                        }
                    }
                    
                    items(entry.value) { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxSize()
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                ),
                        ) {
                            Column(
                                modifier = Modifier.padding(6.dp)
                            ) {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = item.description,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LastMovementsPreview() {
    SafeScreenContainerTest {
        Transactions(transactions = TransactionsDataModelMock)
    }
}


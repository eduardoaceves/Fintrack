/*
 * FilterTransactionsUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */

package com.uagr.kmp.course.domain.usecase.transactions

import com.uagr.kmp.course.domain.model.transations.TransactionItemModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import org.koin.core.annotation.Factory

@Factory
class FilterTransactionsUseCase {
    
    fun getFilteredTransactions(
        searchText : String,
        transactions : TransactionsDataModel?
    ): List<TransactionItemModel>? {
        return if(searchText.isEmpty()) {
            transactions?.items
        } else {
            transactions?.items?.filter {
                it.description.lowercase().contains(searchText.lowercase(), ignoreCase = false) ||
                        it.notes.lowercase().contains(searchText.lowercase(), ignoreCase = false) ||
                        it.type.lowercase().contains(searchText.lowercase(), ignoreCase = false)
            }
        }
    }
    
}
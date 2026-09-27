/*
 * TransactionsDataMock.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.mock

import com.uagr.kmp.course.domain.model.transations.TransactionModel


val transactionDataMock: TransactionModel =
    TransactionModel(
        id = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        accountId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        categoryId=  "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        currency = "MXN",
        type=  "INCOME",
        amount = "+$250",
        description = "Ingreso",
        notes = "Ahorro",
        transactionDate = "2026-09-24T18:30:00Z"
    )

val transactionDataListMock: List<TransactionModel> =
    listOf(
        TransactionModel(
            id = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            accountId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            categoryId=  "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            currency = "MXN",
            type=  "EXPEND",
            amount = "-$250",
            description = "Compra de supermercado",
            notes = "Alimentación",
            transactionDate = "2026-09-24T18:30:00Z"
        ),
        TransactionModel(
            id = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            accountId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            categoryId=  "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            currency = "MXN",
            type=  "INCOME",
            amount = "+$10000",
            description = "Nomina",
            notes = "Ingreso",
            transactionDate = "2026-09-24T18:30:00Z"
        ),
        TransactionModel(
            id = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            accountId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            categoryId=  "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            currency = "MXN",
            type=  "EXPEND",
            amount = "-$600",
            description = "Internet",
            notes = "Servicios",
            transactionDate = "2026-09-24T18:30:00Z"
        ),
        TransactionModel(
            id = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            accountId = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            categoryId=  "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            currency = "MXN",
            type=  "EXPEND",
            amount = "-$500",
            description = "Luz",
            notes = "Servicios",
            transactionDate = "2026-09-24T18:30:00Z"
        ),
    )

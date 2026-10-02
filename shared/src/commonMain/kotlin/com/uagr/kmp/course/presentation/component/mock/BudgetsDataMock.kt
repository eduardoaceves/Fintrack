/*
 * PackagesDataMock.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.mock

import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModelItem

val budgetSummaryDataMock = BudgetSummaryModel(
    spent = "1140.00",
    percentage = "30.81",
    remaining = "2560.00",
    budget = "3700.00"
)

val budgetsDataMock = BudgetsModel(
    listOf(
        BudgetsModelItem(
            id = "ff50a215-f48c-4436-ac75-5e27ab45d127",
            category_id = "5794fcf4-9fc0-42fc-bdad-33d93154d746",
            amount = "300.00",
            version = 1,
            start_date = "2026-09-01"
        ),
        BudgetsModelItem(
            id = "3a6fda7b-1a8b-4fcb-8ee4-d104e8cbad7f",
            category_id = "0a7acef4-cd5e-4e0d-b2ce-1d773cc915e3",
            amount = "1500.00",
            version = 1,
            start_date = "2026-09-01"
        ),
        BudgetsModelItem(
            id = "02b20a7f-8fcc-4d27-9a55-0304158dcb5e",
            category_id = "55224b3f-d4ff-4ce6-ae34-85f05946ef6a",
            amount = "900.00",
            version = 1,
            start_date = "2026-09-01"
        ),
        BudgetsModelItem(
            id = "dbd914a3-ff78-45a8-a433-1c68ba1f54cc",
            category_id = "55f93538-252c-422c-be53-6a9dfddf8c1b",
            amount = "1000.00",
            version = 1,
            start_date = "2026-09-01"
        )
    )
)

val budgetsModelItem =  BudgetsModelItem(
    id = "ff50a215-f48c-4436-ac75-5e27ab45d127",
    category_id = "5794fcf4-9fc0-42fc-bdad-33d93154d746",
    amount = "300.00",
    version = 1,
    start_date = "2026-09-01"
)

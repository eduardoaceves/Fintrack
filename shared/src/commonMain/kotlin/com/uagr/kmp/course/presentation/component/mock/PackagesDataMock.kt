/*
 * PackagesDataMock.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.mock

import com.uagr.kmp.course.domain.model.packages.PackagesDataModel

val packagesDataMock: PackagesDataModel =
    PackagesDataModel(
        id = "0",
        name = "Package 1",
        description = "Description",
        price = "500",
        currency = "MXN",
        stock = "12",
        created_by = "12-03-2000",
        created_at = "12-03-2000",
    )

val packagesDataListMock: List<PackagesDataModel> =
    listOf(
        PackagesDataModel(
            id = "1",
            name = "Package 1",
            description = "Description",
            price = "500",
            currency = "MXN",
            stock = "12",
            created_by = "12-03-2000",
            created_at = "12-03-2000",
        ),
        PackagesDataModel(
            id = "2",
            name = "Package 2",
            description = "Description",
            price = "600",
            currency = "MXN",
            stock = "13",
            created_by = "13-03-2000",
            created_at = "13-03-2000",
        ),
        PackagesDataModel(
            id = "3",
            name = "Package 3",
            description = "Description",
            price = "600",
            currency = "MXN",
            stock = "13",
            created_by = "13-03-2000",
            created_at = "13-03-2000",
        ),
    )

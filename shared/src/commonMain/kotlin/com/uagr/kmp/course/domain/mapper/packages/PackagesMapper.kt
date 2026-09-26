/*
 * PackagesMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.packages

import com.uagr.kmp.course.data.local.model.packages.PackagesEntity
import com.uagr.kmp.course.data.network.model.response.packages.PackagesDataResponse
import com.uagr.kmp.course.data.network.model.response.packages.PackagesResponse
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.model.packages.PackagesModel

fun PackagesResponse.toDomain(): PackagesModel =
    PackagesModel(
        data = data?.map { data -> data.toDomain() } ?: emptyList(),
        success = success ?: false,
        message = message.orEmpty(),
    )

private fun PackagesDataResponse.toDomain(): PackagesDataModel =
    PackagesDataModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        description = description.orEmpty(),
        price = (price ?: 0.00).toString(),
        currency = currency.orEmpty(),
        stock = (stock ?: 0).toString(),
        created_by = created_by.orEmpty(),
        created_at = created_at.orEmpty(),
    )

fun PackagesDataModel.toEntity(): PackagesEntity =
    PackagesEntity(
        id = id,
        name = name,
        description = description,
        price = price,
        currency = currency,
        stock = stock,
        created_by = created_by,
        created_at = created_at,
    )

fun PackagesEntity.toDomain(): PackagesDataModel =
    PackagesDataModel(
        id = id,
        name = name,
        description = description,
        price = price,
        currency = currency,
        stock = stock,
        created_by = created_by,
        created_at = created_at,
    )

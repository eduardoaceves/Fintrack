/*
 * AccountMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.accounts

import com.uagr.kmp.course.data.network.model.response.accounts.AccountResponse
import com.uagr.kmp.course.data.network.model.response.accounts.AccountsItemResponse
import com.uagr.kmp.course.data.network.model.response.accounts.AccountsResponse
import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.accounts.AccountsItemModel

fun AccountResponse.toDomain(): AccountModel =
    AccountModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        type = type.orEmpty(),
        current_balance = current_balance.orEmpty()
    )

fun AccountsResponse.toDomain(): AccountsDataModel =
    AccountsDataModel(
        items = items?.map{ data -> data.toDomain()} ?: emptyList()
    )

fun AccountsItemResponse.toDomain(): AccountsItemModel =
    AccountsItemModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        type = type.orEmpty(),
        current_balance = current_balance.orEmpty()
    )

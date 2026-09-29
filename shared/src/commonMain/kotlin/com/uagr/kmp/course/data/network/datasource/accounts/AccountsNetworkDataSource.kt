/*
 * AccountsNetworkDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.accounts

import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.accounts.AccountsItemModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface AccountsNetworkDataSource {
    suspend fun getAccounts(
        url: String,
    ): NetworkResult<AccountsDataModel>
    
    suspend fun getAccount(
        url: String,
    ): NetworkResult<AccountModel>
}

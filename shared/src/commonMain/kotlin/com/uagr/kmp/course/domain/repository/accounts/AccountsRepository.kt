/*
 * AccountsRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.accounts

import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {
    
    suspend fun getAccount(url : String) : Flow<NetworkResult<AccountModel>>
    suspend fun getAccounts(url : String) : Flow<NetworkResult<AccountsDataModel>>
    

}
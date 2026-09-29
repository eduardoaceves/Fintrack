/*
 * AccountsRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.accounts

import com.uagr.kmp.course.data.network.datasource.accounts.AccountsNetworkDataSource
import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.accounts.AccountsItemModel
import com.uagr.kmp.course.domain.repository.accounts.AccountsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class AccountsRepositoryImpl(
    private val accountsNetworkDataSource: AccountsNetworkDataSource,
    private val dispatcher: CoroutineDispatcher
) : AccountsRepository {
    
    override suspend fun getAccount(url: String): Flow<NetworkResult<AccountModel>> = flow{
        emit( value = accountsNetworkDataSource.getAccount(url = url))
    }.flowOn(context = dispatcher)
    
    override suspend fun getAccounts(url: String): Flow<NetworkResult<AccountsDataModel>> = flow{
        emit( value = accountsNetworkDataSource.getAccounts(url = url))
    }.flowOn(context = dispatcher)
}
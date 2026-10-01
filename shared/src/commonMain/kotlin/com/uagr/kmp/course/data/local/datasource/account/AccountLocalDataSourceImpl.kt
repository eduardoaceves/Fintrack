/*
 * AccountLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.account

import com.uagr.kmp.course.data.local.database.dao.account.AccountDao
import com.uagr.kmp.course.data.local.database.dao.packages.PackagesDao
import com.uagr.kmp.course.data.local.datasource.packages.PackagesLocalDataSource
import com.uagr.kmp.course.domain.mapper.accounts.toEntity
import com.uagr.kmp.course.domain.mapper.packages.toDomain
import com.uagr.kmp.course.domain.mapper.packages.toEntity
import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsItemModel
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class AccountLocalDataSourceImpl(
    private val accountDao : AccountDao,
) : AccountLocalDataSource {
    
    override suspend fun insertAndDeleteAccount(accountModel: AccountsItemModel) {
        accountDao.insertAndDeleteAccount(
            account = accountModel.toEntity())
    }
    
    override suspend fun getAccountID(): String =
        accountDao.getAccountId()
    
}

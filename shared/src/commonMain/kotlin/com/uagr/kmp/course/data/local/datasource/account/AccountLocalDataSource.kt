/*
 * AccountLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.account

import com.uagr.kmp.course.domain.model.accounts.AccountsItemModel

interface AccountLocalDataSource {
    suspend fun insertAndDeleteAccount(accountModel: AccountsItemModel)
    suspend fun getAccountID(): String
}

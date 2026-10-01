/*
 * AccountDao.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database.dao.account

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import androidx.room3.Transaction
import com.uagr.kmp.course.data.local.model.account.AccountEntity
import com.uagr.kmp.course.data.local.model.packages.PackagesEntity
import com.uagr.kmp.course.data.local.model.user.UserEntity

@Dao
interface AccountDao {

    @Transaction
    suspend fun insertAndDeleteAccount(account : AccountEntity) {
        deleteAccounts()
        insertAccount(account = account)
    }

    @Query("DELETE FROM accounts")
    suspend fun deleteAccounts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: AccountEntity): Long
    
    @Query(value = "SELECT id FROM accounts")
    suspend fun getAccountId(): String
}

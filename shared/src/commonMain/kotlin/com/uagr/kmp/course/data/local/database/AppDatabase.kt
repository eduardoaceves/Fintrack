/*
 * AppDatabase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.uagr.kmp.course.data.local.database.dao.AppDatabaseConstructor
import com.uagr.kmp.course.data.local.database.dao.account.AccountDao
import com.uagr.kmp.course.data.local.database.dao.packages.PackagesDao
import com.uagr.kmp.course.data.local.database.dao.user.UserDao
import com.uagr.kmp.course.data.local.model.account.AccountEntity
import com.uagr.kmp.course.data.local.model.packages.PackagesEntity
import com.uagr.kmp.course.data.local.model.user.UserEntity

@Database(
    entities = [
        UserEntity::class,
        PackagesEntity::class,
        AccountEntity::class
    ],
    version = 2,
    exportSchema = false,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun packagesDao(): PackagesDao
    abstract fun userDao(): UserDao
    
    abstract fun accountDao(): AccountDao
}

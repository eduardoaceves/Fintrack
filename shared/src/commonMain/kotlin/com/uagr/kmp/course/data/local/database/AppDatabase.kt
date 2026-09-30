/*
 * AppDatabase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.uagr.kmp.course.data.local.database.dao.AppDatabaseConstructor
import com.uagr.kmp.course.data.local.database.dao.packages.PackagesDao
import com.uagr.kmp.course.data.local.database.dao.user.UserDao
import com.uagr.kmp.course.data.local.model.packages.PackagesEntity
import com.uagr.kmp.course.data.local.model.user.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [
        UserEntity::class,
        PackagesEntity::class
    ],
    version = 1,
    exportSchema = false,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun packagesDao(): PackagesDao
    abstract fun userDao(): UserDao
}

/*@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}*/

/*fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}*/

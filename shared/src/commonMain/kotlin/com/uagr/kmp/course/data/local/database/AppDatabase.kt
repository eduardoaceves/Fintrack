/*
 * AppDatabase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.uagr.kmp.course.data.local.database.dao.packages.PackagesDao
import com.uagr.kmp.course.data.local.database.dao.user.UserDao
import com.uagr.kmp.course.data.local.model.packages.PackagesEntity
import com.uagr.kmp.course.data.local.model.user.UserEntity

@Database(
    entities = [
        PackagesEntity::class,
        UserEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun packagesDao(): PackagesDao
    abstract fun userDao(): UserDao
}

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

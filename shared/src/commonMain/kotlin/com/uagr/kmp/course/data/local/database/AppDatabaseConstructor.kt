/*
 * AppDatabaseConstructor.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor: RoomDatabaseConstructor<AppDatabase>{
    override fun initialize(): AppDatabase
}

package com.uagr.kmp.course.data.local.database.dao

import androidx.room3.RoomDatabaseConstructor
import com.uagr.kmp.course.data.local.database.AppDatabase

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
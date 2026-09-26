/*
 * AppDatabase.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uagr.kmp.course.utils.constant.Constants
import org.koin.mp.KoinPlatform.getKoin

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val context = getKoin().get<Context>()
    val dbFile = context.getDatabasePath(Constants.DATABASE_NAME)
    return Room.databaseBuilder<AppDatabase>(
        context = context,
        name = dbFile.absolutePath,
    )
}

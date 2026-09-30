/*
 * AppDatabase.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.uagr.kmp.course.utils.constant.Constants
import org.koin.mp.KoinPlatform.getKoin

fun getDataBaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(Constants.DATABASE_NAME)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}

actual fun getDataBaseBuilder() : RoomDatabase.Builder<AppDatabase> {
    val context : Context = getKoin().get()
    return getDataBaseBuilder(context)
}

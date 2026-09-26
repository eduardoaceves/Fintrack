/*
 * AppDatabase.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.uagr.kmp.course.utils.constant.Constants
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSApplicationSupportDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> =
    Room.databaseBuilder<AppDatabase>(
        name = applicationSupportDirectory() + "/${Constants.DATABASE_NAME}"
    ).setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())

@OptIn(ExperimentalForeignApi::class)
private fun applicationSupportDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSApplicationSupportDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}

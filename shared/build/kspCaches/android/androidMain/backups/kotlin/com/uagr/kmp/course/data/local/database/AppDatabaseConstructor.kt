package com.uagr.kmp.course.`data`.local.database

import androidx.room.RoomDatabaseConstructor

public actual object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
  actual override fun initialize(): AppDatabase = com.uagr.kmp.course.`data`.local.database.AppDatabase_Impl()
}

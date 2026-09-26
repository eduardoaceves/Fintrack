/*
 * PackagesDao.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database.dao.packages

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.uagr.kmp.course.data.local.model.packages.PackagesEntity

@Dao
interface PackagesDao {

    @Transaction
    suspend fun clearAndInsertPackages(packages: List<PackagesEntity>) {
        deleteAllPackages()
        insertPackages(packages = packages)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPackages(packages: List<PackagesEntity>)

    @Query("SELECT * FROM packages")
    suspend fun getPackages(): List<PackagesEntity>

    @Query("DELETE FROM packages")
    suspend fun deleteAllPackages()
}

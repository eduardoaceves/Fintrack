/*
 * UserDao.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.uagr.kmp.course.data.local.model.user.UserEntity

@Dao
interface UserDao {

    @Transaction
    suspend fun insertUserAndDeleteOld(user: UserEntity) {
        deleteAllUsers()
        insertUser(user)
    }

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity): Long
}

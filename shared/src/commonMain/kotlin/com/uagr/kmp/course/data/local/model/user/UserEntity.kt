/*
 * UserEntity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String?,
    val email: String?,
    val locale: String?,
    val currency: String?,
    val emailVerified: Boolean?,
    val isActive: Boolean?,
)

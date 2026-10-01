/*
 * PackagesEntity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.model.account

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val type: String,
    val currentBalance: String,
)
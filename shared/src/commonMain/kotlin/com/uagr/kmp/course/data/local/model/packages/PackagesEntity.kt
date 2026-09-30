/*
 * PackagesEntity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.model.packages

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "packages")
data class PackagesEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val price: String,
    val currency: String,
    val stock: String,
    val created_by: String,
    val created_at: String,
)

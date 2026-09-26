/*
 * UserModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.user

data class UserModel(
    val id: String,
    val full_name: String,
    val email: String,
    val phone: String,
    val role: String,
)

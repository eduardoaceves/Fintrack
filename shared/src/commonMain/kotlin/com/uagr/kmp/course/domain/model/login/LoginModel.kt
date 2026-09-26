/*
 * LoginModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.login

data class LoginModel(
    val success: Boolean,
    val message: String,
    val data: LoginDataModel?,
)

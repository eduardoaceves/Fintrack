/*
 * UserTokensModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.user

data class UserTokensModel(
    val token_type: String,
    val access_token: String,
    val refresh_token: String,
    val expires_in: Int,
)

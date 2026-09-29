/*
 * LoginMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.login


import com.uagr.kmp.course.data.network.model.response.login.LoginResponse
import com.uagr.kmp.course.domain.model.user.UserTokensModel

fun LoginResponse.toDomain(): UserTokensModel =
    UserTokensModel(
        token_type = token_type.orEmpty(),
        access_token = access_token.orEmpty(),
        refresh_token = refresh_token.orEmpty(),
        expires_in = expires_in ?: 0
    )

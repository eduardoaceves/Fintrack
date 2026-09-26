/*
 * LoginMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.login

import com.uagr.kmp.course.data.network.model.response.login.LoginDataResponse
import com.uagr.kmp.course.data.network.model.response.login.LoginResponse
import com.uagr.kmp.course.data.network.model.response.login.UserResponse
import com.uagr.kmp.course.data.network.model.response.login.UserTokensResponse
import com.uagr.kmp.course.domain.model.login.LoginDataModel
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.domain.model.user.UserModel
import com.uagr.kmp.course.domain.model.user.UserTokensModel

fun LoginResponse.toDomain(): LoginModel =
    LoginModel(
        success = success ?: false,
        message = message.orEmpty(),
        data = data?.toDomain(),
    )

private fun LoginDataResponse.toDomain(): LoginDataModel =
    LoginDataModel(
        user = user?.toDomain(),
        tokens = tokens?.toDomain(),
    )

private fun UserResponse.toDomain(): UserModel =
    UserModel(
        id = id.orEmpty(),
        full_name = full_name.orEmpty(),
        email = email.orEmpty(),
        phone = (phone ?: 0).toString(),
        role = role.orEmpty(),
    )

private fun UserTokensResponse.toDomain(): UserTokensModel =
    UserTokensModel(
        token_type = token_type.orEmpty(),
        access_token = access_token.orEmpty(),
        refresh_token = refresh_token.orEmpty(),
        expires_in = expires_in ?: 0,
    )

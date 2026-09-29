/*
 * RgisterMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.register

import com.uagr.kmp.course.data.network.model.response.register.RegisterDataResponse
import com.uagr.kmp.course.data.network.model.response.register.TokenDataResponse
import com.uagr.kmp.course.data.network.model.response.register.UserDataResponse
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.model.user.UserTokensModel

fun RegisterDataResponse.toDomain(): RegisterDataModel =
    RegisterDataModel(
        user = user?.toDomain(),
        tokens = tokens?.toDomain(),
    )

fun UserDataResponse.toDomain(): UserDataModel =
    UserDataModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        email = email.orEmpty(),
        locale = locale.orEmpty(),
        currency = currency.orEmpty(),
        email_verified = email_verified?:false,
        isActive = is_active?:false
    )

fun TokenDataResponse.toDomain() : UserTokensModel =
    UserTokensModel(
        access_token = access_token.orEmpty(),
        refresh_token = refresh_token.orEmpty(),
        token_type = token_type.orEmpty(),
        expires_in = expires_in ?: 0,
    )
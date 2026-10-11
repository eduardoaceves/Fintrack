/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.user

import com.uagr.kmp.course.data.local.model.user.UserEntity
import com.uagr.kmp.course.data.network.model.response.user.UserResponse
import com.uagr.kmp.course.domain.model.user.UserDataModel

fun UserResponse.toDomain(): UserDataModel =
    UserDataModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        email = email.orEmpty(),
        locale = locale.orEmpty(),
        currency = currency.orEmpty(),
        email_verified = email_verified ?: false,
        isActive = is_active ?: false
    )

fun UserEntity.toDomain(): UserDataModel =
    UserDataModel(
        id = id,
        name = name.orEmpty(),
        email = email.orEmpty(),
        locale = locale.orEmpty(),
        currency = currency.orEmpty(),
        email_verified = emailVerified?:false,
        isActive = isActive?:false
    )

fun UserDataModel.toEntity(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        email = email,
        locale = locale,
        currency = currency,
        emailVerified = email_verified,
        isActive = isActive
    )

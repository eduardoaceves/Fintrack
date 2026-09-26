/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.user

import com.uagr.kmp.course.data.local.model.user.UserEntity
import com.uagr.kmp.course.domain.model.user.UserModel

fun UserEntity.toDomain(): UserModel =
    UserModel(
        id = id.toString(),
        full_name = name.orEmpty(),
        email = email.orEmpty(),
        phone = phone.orEmpty(),
        role = role.orEmpty(),
    )

fun UserModel.toEntity(): UserEntity =
    UserEntity(
        name = full_name,
        email = email,
        phone = phone,
        role = role,
    )

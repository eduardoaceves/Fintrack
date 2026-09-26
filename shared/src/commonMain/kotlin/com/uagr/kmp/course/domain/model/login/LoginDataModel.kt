/*
 * LoginDataModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.login

import com.uagr.kmp.course.domain.model.user.UserModel
import com.uagr.kmp.course.domain.model.user.UserTokensModel

data class LoginDataModel(
    val user: UserModel?,
    val tokens: UserTokensModel?,
)

/*
 * RegisterDataModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.register

import com.uagr.kmp.course.domain.model.user.TokenDataModel
import com.uagr.kmp.course.domain.model.user.UserDataModel

data class RegisterDataModel(
	val tokens: TokenDataModel?,
	val user: UserDataModel?
)


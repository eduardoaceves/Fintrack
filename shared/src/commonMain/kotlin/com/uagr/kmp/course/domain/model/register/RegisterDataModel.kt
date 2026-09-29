/*
 * RegisterDataModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.register

import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.model.user.UserTokensModel

data class RegisterDataModel(
	val tokens: UserTokensModel?,
	val user: UserDataModel?
)


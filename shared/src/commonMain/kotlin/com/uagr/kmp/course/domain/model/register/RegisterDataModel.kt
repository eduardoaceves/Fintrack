/*
 * RegisterDataModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.register

data class RegisterDataModel(
	val tokens: TokenDataModel?,
	val user: UserDataModel?
)

data class UserDataModel(
	val id: String,
	val name: String,
	val email: String,
	val locale: String,
	val currency: String,
	val email_verified: Boolean,
	val isActive: Boolean,
)

data class TokenDataModel(
	val access_token: String,
	val refresh_token: String,
	val token_type: String,
	val expires_in: Int,
)


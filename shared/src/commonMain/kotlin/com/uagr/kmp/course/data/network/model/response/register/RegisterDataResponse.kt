/*
 * RegisterDataResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class RegisterDataResponse(
	val tokens: TokenDataResponse?,
	val user: UserDataResponse?,
) : BaseResponse()

@Serializable
data class UserDataResponse(
	val is_active: Boolean?,
	val email_verified: Boolean?,
	val updated_at: String?,
	val timezone: String?,
	val name: String?,
	val created_at: String?,
	val currency: String?,
	val id: String?,
	val locale: String?,
	val email: String?,
)

@Serializable
data class TokenDataResponse(
	val access_token: String?,
	val refresh_token: String?,
	val token_type: String?,
	val expires_in: Int?
)


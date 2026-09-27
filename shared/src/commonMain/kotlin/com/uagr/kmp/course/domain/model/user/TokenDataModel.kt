package com.uagr.kmp.course.domain.model.user

data class TokenDataModel(
	val access_token: String,
	val refresh_token: String,
	val token_type: String,
	val expires_in: Int,
)
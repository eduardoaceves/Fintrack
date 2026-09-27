package com.uagr.kmp.course.domain.model.user

data class UserDataModel(
	val id: String,
	val name: String,
	val email: String,
	val locale: String,
	val currency: String,
	val email_verified: Boolean,
	val isActive: Boolean,
)
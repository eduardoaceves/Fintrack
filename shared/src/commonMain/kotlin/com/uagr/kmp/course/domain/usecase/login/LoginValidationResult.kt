/*
 * LoginValidationResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

sealed class LoginValidationResult {
    data object EmptyFields : LoginValidationResult()
    data object EmailEmpty : LoginValidationResult()
    data object WrongEmailFormat : LoginValidationResult()
    data object PasswordEmpty : LoginValidationResult()
    data object Success : LoginValidationResult()
}

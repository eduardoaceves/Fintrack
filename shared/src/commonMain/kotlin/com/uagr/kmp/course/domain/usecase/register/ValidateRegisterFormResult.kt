/*
 * ValidateRegisterFormResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

sealed class ValidateRegisterFormResult {
    data object EmptyFields : ValidateRegisterFormResult()
    data object NameEmpty : ValidateRegisterFormResult()
    data object EmailEmpty : ValidateRegisterFormResult()
    data object WrongEmailFormat : ValidateRegisterFormResult()
    data object PasswordEmpty : ValidateRegisterFormResult()
    data object ConfirmPasswordEmpty : ValidateRegisterFormResult()
    data object WrongPasswords : ValidateRegisterFormResult()
    data object Success : ValidateRegisterFormResult()
}
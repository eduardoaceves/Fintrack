/*
 * ValidateRegisterFormUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

import com.uagr.kmp.course.domain.usecase.login.LoginValidationResult
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.text.validateEmailFormat
import com.uagr.kmp.course.utils.text.validateLength
import org.koin.core.annotation.Factory
import kotlin.String

@Factory
class ValidateRegisterFormUseCase {

    fun validateFormOnClick(
        name : String,
        email : String,
        password : String,
        confirmPassword : String,
    ) : ValidateRegisterFormResult{
        
        return when{
           name.isBlank() && email.isBlank() && password.isBlank() && confirmPassword.isBlank() ->
                ValidateRegisterFormResult.EmptyFields
            name.isBlank() ->
                ValidateRegisterFormResult.NameEmpty
            email.isBlank() ->
                ValidateRegisterFormResult.EmailEmpty
            !email.validateEmailFormat() ->
                ValidateRegisterFormResult.WrongEmailFormat
            password.isBlank() ->
                ValidateRegisterFormResult.PasswordEmpty
            confirmPassword.isBlank() ->
                ValidateRegisterFormResult.ConfirmPasswordEmpty
            password != confirmPassword ->
                ValidateRegisterFormResult.WrongPasswords
            else ->
                ValidateRegisterFormResult.Success
        }
    }
    
    fun validateLengthOnChange(
        name : String = "",
        email : String = "",
        password: String = "",
        confirmPassword : String = "",
    ) : ValidateRegisterFormResult
    {
        return when {
            name.length > Constants.NAME_LENGTH ->
                ValidateRegisterFormResult.NameWrongLength
            email.length > Constants.EMAIL_LENGTH ->
                ValidateRegisterFormResult.EmailWrongLength
            password.length > Constants.PASSWORD_LENGTH ->
                ValidateRegisterFormResult.PasswordWrongLength
            confirmPassword.length > Constants.PASSWORD_LENGTH ->
                ValidateRegisterFormResult.ConfirmPasswordWrongLength
            else -> ValidateRegisterFormResult.Success
        }
    }
    
}

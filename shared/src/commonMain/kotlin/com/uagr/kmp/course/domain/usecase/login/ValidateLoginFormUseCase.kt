/*
 * ValidateLoginFormUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

import com.uagr.kmp.course.utils.text.validateEmailFormat
import org.koin.core.annotation.Factory

@Factory
class ValidateLoginFormUseCase {
    
    operator fun invoke(
        email : String,
        password : String
    ) : LoginValidationResult{
        
        if(email.isBlank() && password.isBlank()){
            return LoginValidationResult.EmptyFields
        }
        
        if(email.isBlank()) {
            return LoginValidationResult.EmailEmpty
        }
        
        if(!validateEmailFormat(email)){
            return LoginValidationResult.WrongEmailFormat
        }
        
        
        if(password.isBlank()){
            return LoginValidationResult.PasswordEmpty
        }
        
        return LoginValidationResult.Success
    }
}

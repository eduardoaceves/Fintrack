/*
 * ValidateRegisterFormUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

import com.uagr.kmp.course.utils.text.validateEmailFormat
import org.koin.core.annotation.Factory

@Factory
class ValidateRegisterFormUseCase {

    operator fun invoke(
        name : String,
        email : String,
        password : String,
        confirmPassword : String,
    ) : ValidateRegisterFormResult{
        
        if(name.isBlank() && email.isBlank() && password.isBlank() && confirmPassword.isBlank()){
            return ValidateRegisterFormResult.EmptyFields
        }
        
        if(name.isBlank()) {
            return ValidateRegisterFormResult.NameEmpty
        }
        
        if(email.isBlank()) {
          return ValidateRegisterFormResult.EmailEmpty
        }
        
        if(!validateEmailFormat(email)){
            return ValidateRegisterFormResult.WrongEmailFormat
        }
        
        if(password.isBlank()){
            return ValidateRegisterFormResult.PasswordEmpty
        }
        
        if(confirmPassword.isBlank()){
            return ValidateRegisterFormResult.ConfirmPasswordEmpty
        }
        
        if(confirmPassword != password){
            return ValidateRegisterFormResult.WrongPasswords
        }
        
        return ValidateRegisterFormResult.Success
    }
}

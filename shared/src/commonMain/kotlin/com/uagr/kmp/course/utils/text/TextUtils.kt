package com.uagr.kmp.course.utils.text

import com.uagr.kmp.course.utils.constant.Constants

fun validateEmailFormat(email : String) : Boolean {
    return email.matches(Regex(Constants.EMAIL_PATTERN))
}

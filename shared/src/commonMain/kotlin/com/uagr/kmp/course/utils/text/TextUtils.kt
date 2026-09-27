package com.uagr.kmp.course.utils.text

import com.uagr.kmp.course.utils.constant.Constants

fun validateEmailFormat(email : String) : Boolean {
    return email.matches(Regex(Constants.EMAIL_PATTERN))
}

fun compareDates(){
    /*val d = "2026-09-24T18:30:00Z"
    LocalDate.parse(d)
    
    val dateFormat = LocalDate.Format {
        monthNumber(padding = Padding.SPACE)
        char('/')
        day()
        char(' ')
        year()
    }
    
    val x = dateFormat*/
    
}
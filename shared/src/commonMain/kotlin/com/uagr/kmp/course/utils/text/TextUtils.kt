package com.uagr.kmp.course.utils.text

import com.uagr.kmp.course.utils.constant.Constants

fun validateEmailFormat(email : String) : Boolean {
    return email.matches(Regex(Constants.EMAIL_PATTERN))
}

fun getTransactionTitle(categoryID : String) : String{
    return when(categoryID){
        Constants.CATEGORY_TRANSPORT -> "Transporte"
        Constants.CATEGORY_SUBSCRIPTIONS_POSTMAN -> "Subscripciones"
        Constants.CATEGORY_SERVICES -> "Servicios"
        Constants.CATEGORY_HEALTH -> "Salud"
        Constants.CATEGORY_HOME -> "Casa"
        Constants.CATEGORY_ENTERTAINMENT -> "Entretenimiento"
        Constants.CATEGORY_BUYS -> "Compras"
        Constants.CATEGORY_FEED -> "Alimentación"
        Constants.CATEGORY_SALES -> "Ventas"
        else -> "Otros"
    }
}

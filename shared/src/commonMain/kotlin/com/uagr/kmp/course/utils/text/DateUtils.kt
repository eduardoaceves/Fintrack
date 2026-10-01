package com.uagr.kmp.course.utils.text

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

@OptIn(FormatStringsInDatetimeFormats::class)
fun getTransactionDate(date : String) : String {
    try{
        /** system **/
        val currentTime = Clock.System.now()
        val timeZone = TimeZone.currentSystemDefault()
        val systemDay = currentTime.toLocalDateTime(timeZone).day
        if(date.contains('T')){
            val d = date.split("T")
            /** data **/
            val dateFormat = LocalDateTime.Format { byUnicodePattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'") }
            val dateTime = LocalDateTime.parse(date, dateFormat)
            val dataDay = LocalDateTime.parse(date, dateFormat).day
            
            return if(systemDay==dataDay){
                "Hoy"
            } else if(systemDay-dataDay==1){
                "Ayer"
            } else {
                dataDay.toString().plus(" de ").plus(getMonth(dateTime.month))
            }
        } else {
            return date
        }
    } catch (e : Exception){
        return ""
    }
}

fun getTransactionTitle() : String {
    /** system **/
    val currentTime = Clock.System.now()
    val timeZone = TimeZone.currentSystemDefault()
    val systemYear = currentTime.toLocalDateTime(timeZone).year
    val systemMonth = currentTime.toLocalDateTime(timeZone).month
    return getMonth(systemMonth).plus(" ").plus(systemYear)
}

private fun getMonth(month: Month) : String{
    return when (month) {
        Month.JANUARY -> "Enero"
        Month.FEBRUARY -> "Febrero"
        Month.MARCH -> "Marzo"
        Month.APRIL -> "Abril"
        Month.MAY -> "Mayo"
        Month.JUNE -> "Junio"
        Month.JULY -> "Julio"
        Month.AUGUST -> "Agosto"
        Month.SEPTEMBER -> "Septiembre"
        Month.OCTOBER -> "Octubre"
        Month.NOVEMBER -> "Noviembre"
        Month.DECEMBER -> "Diciembre"
    }
}
package com.example.finance.ui.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.toBrazilianDate(): String {
    val formater = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))

    return formater.format(this.time)
}
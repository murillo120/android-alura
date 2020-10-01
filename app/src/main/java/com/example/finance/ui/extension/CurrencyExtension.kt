package com.example.finance.ui.extension

import java.text.DecimalFormat
import java.util.Locale

fun Double.toBrazilianCurrency(): String {

    val currencyInstance = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))

    return currencyInstance.format(this).replace("R$", "R$ ")
}
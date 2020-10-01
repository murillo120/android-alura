package com.example.finance.ui.extension

fun String.reduceTo(qtd: Int): String {
    if (this.length > qtd) return this.substring(0, qtd) + "..."
    return this
}
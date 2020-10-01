package com.example.finance.ui.models

import java.util.*

data class Transacao(
 val title: String,
 val debit: Debit,
 val value: String,
 val data: Calendar = Calendar.getInstance()) {

}
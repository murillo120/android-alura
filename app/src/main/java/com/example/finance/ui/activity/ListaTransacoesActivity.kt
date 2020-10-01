package com.example.finance.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.finance.R
import com.example.finance.ui.adapter.ListaAdapter
import com.example.finance.ui.extension.toBrazilianCurrency
import com.example.finance.ui.models.Debit
import com.example.finance.ui.models.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val list = setTransacoesList()
        setCardValues(list)
        setAdapter(list)

    }

    fun setTransacoesList(): List<Transacao> {
        return listOf(
            Transacao(title = "Lazer na praia com amigos", debit = Debit.RECEITA, value = "2000"),
            Transacao("Santander", Debit.DESPESA, "100"),
            Transacao("itau", Debit.RECEITA, "300"),
            Transacao("bradesco", Debit.DESPESA, "400"),
            Transacao("c6", Debit.RECEITA, "600"),
            Transacao("nubank", Debit.DESPESA, "800")
        )
    }

    fun setCardValues(data: List<Transacao>) {

        val receita = data
            .filter {it.debit == Debit.RECEITA}
            .sumByDouble {it.value.toDouble()}

        val despesa = data
            .filter { it.debit == Debit.DESPESA }
            .sumByDouble { it.value.toDouble() }

        resumo_card_receita.text = receita.toBrazilianCurrency()
        resumo_card_despesa.text = despesa.toBrazilianCurrency()

        setColorOnTotalValue(receita - despesa)
    }

    fun setColorOnTotalValue(value: Double) {

        resumo_card_total.text = value.toBrazilianCurrency()

        if (value > 0) resumo_card_total.setTextColor(ContextCompat.getColor(this, R.color.receita))
        else resumo_card_total.setTextColor(ContextCompat.getColor(this, R.color.despesa))

    }

    fun setAdapter(data: List<Transacao>) {

        val adapter = ListaAdapter(data)
        lista_transacoes_listview.adapter = adapter

    }
}
package com.example.finance.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.finance.R
import com.example.finance.ui.extension.reduceTo
import com.example.finance.ui.extension.toBrazilianCurrency
import com.example.finance.ui.extension.toBrazilianDate
import com.example.finance.ui.models.Debit
import com.example.finance.ui.models.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*


class ListaAdapter(val list: List<Transacao>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.transacao_item, parent, false)

        val item = list[position]

        when (item.debit) {
            Debit.DESPESA -> {
                view.transacao_icone.setImageResource(R.drawable.icone_transacao_item_despesa)
                view.transacao_valor.setTextColor(
                    ContextCompat.getColor(
                        parent!!.context,
                        R.color.despesa
                    )
                )
            }
            Debit.RECEITA -> {
                view.transacao_icone.setImageResource(R.drawable.icone_transacao_item_receita)
                view.transacao_valor.setTextColor(
                    ContextCompat.getColor(
                        parent!!.context,
                        R.color.receita
                    )
                )
            }
        }



        view.transacao_categoria.text = item.title.reduceTo(14)
        view.transacao_data.text = item.data.toBrazilianDate()
        view.transacao_valor.text = item.value.toDouble().toBrazilianCurrency()

        return view
    }

    override fun getItem(position: Int): Any {

        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = list.size


}
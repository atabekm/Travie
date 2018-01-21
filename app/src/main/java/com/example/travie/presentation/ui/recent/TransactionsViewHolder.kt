package com.example.travie.presentation.ui.recent

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.travie.R
import com.example.travie.domain.model.Transaction
import com.example.travie.util.dayText
import com.example.travie.util.getCurrencyText
import com.example.travie.util.headerText
import com.example.travie.util.monthText
import java.util.*

/**
 * Created by atabek on 01/21/2018.
 */

class TransactionsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun setItem(transaction: Transaction) {
        itemView.findViewById<TextView>(R.id.transactionDay).text = transaction.date.dayText()
        itemView.findViewById<TextView>(R.id.transactionMonth).text = transaction.date.monthText()
        itemView.findViewById<TextView>(R.id.transactionAmount).text = transaction.amount.getCurrencyText()
        itemView.findViewById<TextView>(R.id.transactionTitle).text = transaction.title
        itemView.findViewById<TextView>(R.id.transactionCategory).text = transaction.categories[0].title
        itemView.setOnClickListener { Toast.makeText(itemView.context, transaction.title, LENGTH_SHORT).show() }
    }

}

class HeaderViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun setItem(date: Date) {
        itemView.findViewById<TextView>(R.id.headerTitle).text = date.headerText()
    }

}
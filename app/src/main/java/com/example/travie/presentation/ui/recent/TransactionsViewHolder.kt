package com.example.travie.presentation.ui.recent

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.travie.R
import com.example.travie.domain.model.Transaction
import com.example.travie.util.day
import com.example.travie.util.getCurrency
import com.example.travie.util.month

/**
 * Created by atabek on 01/21/2018.
 */

class TransactionsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun setItem(transaction: Transaction) {
        itemView.findViewById<TextView>(R.id.transactionDay).text = transaction.date.day()
        itemView.findViewById<TextView>(R.id.transactionMonth).text = transaction.date.month()
        itemView.findViewById<TextView>(R.id.transactionAmount).text = transaction.amount.getCurrency()
        itemView.findViewById<TextView>(R.id.transactionTitle).text = transaction.title
        itemView.findViewById<TextView>(R.id.transactionCategory).text = transaction.categories[0].title
    }

}

class HeaderViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

}
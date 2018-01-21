package com.example.travie.presentation.ui.recent

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travie.R
import com.example.travie.presentation.ui.recent.TransactionConverter.TYPE_HEADER
import com.example.travie.presentation.ui.recent.TransactionConverter.TYPE_TRANSACTION

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var transactions = listOf<TransactionWrapper>()
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(inflater.inflate(R.layout.item_header, parent, false))
            TYPE_TRANSACTION -> TransactionsViewHolder(inflater.inflate(R.layout.item_transaction, parent, false))
            else -> TransactionsViewHolder(View(context))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (transactions[position].type) {
            TYPE_HEADER -> (holder as HeaderViewHolder).setItem(transactions[position].transaction.date)
            TYPE_TRANSACTION -> (holder as TransactionsViewHolder).setItem(transactions[position].transaction)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return transactions[position].type
    }

    override fun getItemCount() = transactions.size

    fun updateTransactions(transactions: List<TransactionWrapper>) {
        this.transactions = transactions
        notifyDataSetChanged()
    }
}
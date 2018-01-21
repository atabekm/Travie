package com.example.travie.presentation.ui.recent

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travie.R
import com.example.travie.domain.model.Transaction

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var transactions = listOf<Transaction>()
    var inflater: LayoutInflater = LayoutInflater.from(context)

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_TRANSACTION = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return TransactionsViewHolder(inflater.inflate(R.layout.item_transaction, parent, false))
//        return when (viewType) {
//            TYPE_HEADER -> HeaderViewHolder(inflater.inflate(R.layout.item_header, parent, false))
//            TYPE_TRANSACTION -> TransactionsViewHolder(inflater.inflate(R.layout.item_transaction, parent, false))
//            else -> TransactionsViewHolder(View(context))
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as TransactionsViewHolder).setItem(transactions[position])
    }

    override fun getItemCount() = transactions.size

    fun updateTransactions(transactions: List<Transaction>) {
        this.transactions = transactions
        notifyDataSetChanged()
    }
}
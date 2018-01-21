package com.example.travie.presentation.ui.recent

/**
 * Created by atabek on 01/20/2018.
 */

interface RecentTransactionsView {

    fun updateTransactions(transactions: List<TransactionWrapper>)
    fun showProgressBar(visible: Boolean)

}
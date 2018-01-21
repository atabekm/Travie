package com.example.travie.presentation.ui.recent

import com.example.travie.domain.model.Transaction

/**
 * Created by atabek on 01/20/2018.
 */

interface RecentTransactionsView {

    fun updateTransactions(transactions: List<Transaction>)

}
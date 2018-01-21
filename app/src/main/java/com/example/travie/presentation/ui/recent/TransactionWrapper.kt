package com.example.travie.presentation.ui.recent

import com.example.travie.domain.model.Transaction
import com.example.travie.util.day
import com.example.travie.util.month

/**
 * Created by atabek on 01/21/2018.
 */

data class TransactionWrapper(val type: Int, val transaction: Transaction)

object TransactionConverter {
    const val TYPE_HEADER = 0
    const val TYPE_TRANSACTION = 1

    fun toWrapper(transactions: List<Transaction>): List<TransactionWrapper> {
        val transactionWrappers = mutableListOf<TransactionWrapper>()
        var currentMonth = 0
        var currentDay = 0
        for (t in transactions) {
            if (currentDay != t.date.day() || currentMonth != t.date.month()) {
                currentDay = t.date.day()
                currentMonth = t.date.month()
                transactionWrappers.add(TransactionWrapper(TYPE_HEADER, t))
            }

            transactionWrappers.add(TransactionWrapper(TYPE_TRANSACTION, t))
        }

        return transactionWrappers
    }

}
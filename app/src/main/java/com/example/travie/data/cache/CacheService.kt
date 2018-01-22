package com.example.travie.data.cache

import com.example.travie.domain.model.Transaction

/**
 * Created by atabek on 01/22/2018.
 */

class CacheService {
    private var lastCacheTime = 0L
    private var transactions = listOf<Transaction>()

    fun set(time: Long, transactionList: List<Transaction>) {
        lastCacheTime = time
        transactions = transactionList
    }

    fun isValid(time: Long): Boolean {
        if (lastCacheTime == 0L) return false
        return (time - lastCacheTime) < 5 * 60 * 1000
    }

    fun getTransactions(): List<Transaction> {
        return transactions
    }

}
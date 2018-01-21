package com.example.travie.domain.repository

import com.example.travie.domain.model.Transaction
import io.reactivex.Single

/**
 * Created by atabek on 01/20/2018.
 */

interface TransactionRepository {
    fun getTransactions(): Single<List<Transaction>>
}
package com.example.travie.domain.interactor

import com.example.travie.domain.model.Transaction
import com.example.travie.domain.repository.TransactionRepository
import io.reactivex.Completable

/**
 * Created by atabek on 01/22/2018.
 */

class CacheTransactionsUseCase(private val repository: TransactionRepository) {

    fun execute(transactions: List<Transaction>): Completable = repository.cacheTransactions(transactions)

}
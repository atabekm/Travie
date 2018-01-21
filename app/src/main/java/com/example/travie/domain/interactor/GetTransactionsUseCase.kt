package com.example.travie.domain.interactor

import com.example.travie.domain.model.Transaction
import com.example.travie.domain.repository.TransactionRepository
import io.reactivex.Single

/**
 * Created by atabek on 01/20/2018.
 */

class GetTransactionsUseCase(private val repository: TransactionRepository) {

    fun execute(): Single<List<Transaction>> = repository.getTransactions()

}

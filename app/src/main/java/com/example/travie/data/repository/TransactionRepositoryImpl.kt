package com.example.travie.data.repository

import com.example.travie.data.network.TravieService
import com.example.travie.domain.model.Transaction
import com.example.travie.domain.repository.TransactionRepository
import io.reactivex.Single

/**
 * Created by atabek on 01/21/2018.
 */

class TransactionRepositoryImpl(private val service: TravieService) : TransactionRepository {

    override fun getTransactions(): Single<List<Transaction>> = service.getTransactions()

}
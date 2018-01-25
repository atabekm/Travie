package com.example.travie.data.repository

import com.example.travie.data.cache.CacheService
import com.example.travie.data.network.TravieService
import com.example.travie.domain.model.Transaction
import com.example.travie.domain.repository.TransactionRepository
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*

/**
 * Created by atabek on 01/21/2018.
 */

class TransactionRepositoryImpl(private val networkService: TravieService,
                                private val cacheService: CacheService) : TransactionRepository {

    override fun getTransactions(): Single<List<Transaction>> {
        return if (cacheService.isValid(Date().time)) {
            Observable.fromArray(cacheService.getTransactions()).singleOrError()
        } else {
            networkService.getTransactions()
                    .doOnSuccess { cacheService.set(Date().time, it) }
        }
    }

}
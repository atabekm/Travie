package com.example.travie.data.network

import com.example.travie.domain.model.Transaction
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by atabek on 01/21/2018.
 */

interface TravieService {

    @GET("/bins/71zqh")
    fun getTransactions(): Single<List<Transaction>>

}
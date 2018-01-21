package com.example.travie.di.module

import com.example.travie.data.network.TravieService
import com.example.travie.data.repository.TransactionRepositoryImpl
import com.example.travie.domain.interactor.GetTransactionsUseCase
import com.example.travie.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by atabek on 01/21/2018.
 */

@Module
class DomainModule {

    @Provides
    @Singleton
    fun providesTransactionRepository(service: TravieService): TransactionRepository = TransactionRepositoryImpl(service)

    @Provides
    @Singleton
    fun providesTransactionUseCase(repository: TransactionRepository) = GetTransactionsUseCase(repository)

}
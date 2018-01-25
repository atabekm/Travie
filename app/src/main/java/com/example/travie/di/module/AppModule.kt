package com.example.travie.di.module

import com.example.travie.TravieApp
import com.example.travie.di.scheduler.AppScheduler
import com.example.travie.domain.interactor.GetTransactionsUseCase
import com.example.travie.presentation.ui.recent.RecentTransactionsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by atabek on 01/21/2018.
 */

@Module
class AppModule(private val app: TravieApp) {

    @Provides
    @Singleton
    fun providesApp() = app

    @Provides
    @Singleton
    fun providesContext() = app.applicationContext

    @Provides
    @Singleton
    fun providesScheduler() = AppScheduler()

    @Provides
    @Singleton
    fun providesRecentTransactionsPresenter(getTransactionsUseCase: GetTransactionsUseCase,
                                            scheduler: AppScheduler)
            = RecentTransactionsPresenter(getTransactionsUseCase, scheduler)
}
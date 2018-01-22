package com.example.travie.presentation.ui.recent

import com.example.travie.di.scheduler.AppScheduler
import com.example.travie.domain.interactor.GetTransactionsUseCase
import com.example.travie.domain.model.Transaction

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsPresenter(
        private val useCase: GetTransactionsUseCase,
        private val scheduler: AppScheduler
) {
    private lateinit var view: RecentTransactionsView

    fun init(view: RecentTransactionsView) {
        this.view = view
    }

    fun getRecentTransactions() {
        view.showProgressBar(true)
        useCase.execute()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(this::updateTransactions)
    }

    private fun updateTransactions(transactions: List<Transaction>) {
        view.updateTransactions(TransactionConverter.toWrapper(transactions))
        view.showProgressBar(false)
    }
}
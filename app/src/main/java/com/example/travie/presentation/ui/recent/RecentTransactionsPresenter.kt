package com.example.travie.presentation.ui.recent

import com.example.travie.di.scheduler.SchedulerProvider
import com.example.travie.domain.interactor.GetTransactionsUseCase
import com.example.travie.domain.model.Transaction

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsPresenter(
        private val getTransactionsUseCase: GetTransactionsUseCase,
        private val scheduler: SchedulerProvider
) {
    private lateinit var view: RecentTransactionsView

    fun init(view: RecentTransactionsView) {
        this.view = view
    }

    fun getRecentTransactions() {
        view.showProgressBar(true)
        getTransactionsUseCase.execute()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(this::updateTransactions, this::showError)
    }

    private fun updateTransactions(transactions: List<Transaction>) {
        view.updateTransactions(TransactionConverter.toWrapper(transactions))
        view.showProgressBar(false)
    }

    private fun showError(throwable: Throwable) {
        view.showProgressBar(false)
        view.showErrorMessage(throwable.message.toString())
    }
}
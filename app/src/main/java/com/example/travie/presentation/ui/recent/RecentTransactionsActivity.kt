package com.example.travie.presentation.ui.recent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.travie.R
import com.example.travie.TravieApp
import com.example.travie.domain.model.Transaction
import javax.inject.Inject

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsActivity: AppCompatActivity(), RecentTransactionsView {

    @Inject lateinit var presenter: RecentTransactionsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent)
        (application as TravieApp).component.inject(this)

        presenter.init(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getRecentTransactions()
    }

    override fun updateTransactions(transactions: List<Transaction>) {
        Log.d("mytest", "size: " + transactions.size)
    }
}
package com.example.travie.presentation.ui.recent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.travie.R
import com.example.travie.TravieApp
import kotlinx.android.synthetic.main.activity_recent.*
import javax.inject.Inject

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsActivity: AppCompatActivity(), RecentTransactionsView {
    @Inject lateinit var presenter: RecentTransactionsPresenter

    private lateinit var adapter: RecentTransactionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent)
        (application as TravieApp).component.inject(this)

        setSupportActionBar(recentTransactionsToolbar)
        supportActionBar?.setTitle(R.string.recent_transactions)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        presenter.init(this)
        adapter = RecentTransactionsAdapter(this)
        recentTransactionsList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getRecentTransactions()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun updateTransactions(transactions: List<TransactionWrapper>) {
        adapter.updateTransactions(transactions)
    }

    override fun showProgressBar(visible: Boolean) {
        recentTransactionsProgressBar.visibility = if (visible) VISIBLE else GONE
    }
}
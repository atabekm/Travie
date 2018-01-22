package com.example.travie.presentation.ui.recent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travie.R
import com.example.travie.TravieApp
import kotlinx.android.synthetic.main.fragment_recent.*
import javax.inject.Inject

/**
 * Created by atabek on 01/22/2018.
 */

class RecentTransactionsFragment: Fragment(), RecentTransactionsView {
    @Inject lateinit var presenter: RecentTransactionsPresenter

    private lateinit var adapter: RecentTransactionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity.application as TravieApp).component.inject(this)

        presenter.init(this)
        adapter = RecentTransactionsAdapter(activity)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_recent, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recentTransactionsList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getRecentTransactions()
    }

    override fun updateTransactions(transactions: List<TransactionWrapper>) {
        adapter.updateTransactions(transactions)
    }

    override fun showProgressBar(visible: Boolean) {
        recentTransactionsProgressBar.visibility = if (visible) View.VISIBLE else View.GONE
    }

}
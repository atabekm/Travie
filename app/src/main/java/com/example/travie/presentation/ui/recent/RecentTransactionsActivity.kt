package com.example.travie.presentation.ui.recent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.travie.R
import kotlinx.android.synthetic.main.activity_recent.*

/**
 * Created by atabek on 01/20/2018.
 */

class RecentTransactionsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent)

        setSupportActionBar(recentTransactionsToolbar)
        supportActionBar?.setTitle(R.string.recent_transactions)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        recentTransactionsBottomNavigation.setOnNavigationItemSelectedListener {
            openFragment(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
        recentTransactionsBottomNavigation.selectedItemId = R.id.action_track
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun openFragment(menuId: Int) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.recentTransactionsContainer, when (menuId) {
                    R.id.action_track -> RecentTransactionsFragment()
                    R.id.action_safely_spend -> OtherFragment.getInstance(R.string.safely_spend)
                    R.id.action_notifications -> OtherFragment.getInstance(R.string.notifications)
                    R.id.action_settings -> OtherFragment.getInstance(R.string.settings)
                    else -> OtherFragment.getInstance(R.string.other)
                })
                .commit()
    }
}
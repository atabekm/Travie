package com.example.travie.presentation.ui.recent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
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

        supportFragmentManager
                .beginTransaction()
                .add(R.id.recentTransactionsContainer, RecentTransactionsFragment())
                .commit()

        recentTransactionsBottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_track -> Toast.makeText(this, "track", Toast.LENGTH_SHORT).show()
                R.id.action_safely_spend -> Toast.makeText(this, "safely_spend", Toast.LENGTH_SHORT).show()
                R.id.action_notifications -> Toast.makeText(this, "notifications", Toast.LENGTH_SHORT).show()
                R.id.action_settings -> Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
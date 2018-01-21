package com.example.travie.presentation.ui.start

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.example.travie.R
import com.example.travie.presentation.ui.recent.RecentTransactionsActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startSignIn.setOnClickListener {
            startActivity(Intent(this, RecentTransactionsActivity::class.java))
        }

        val haveAccount = getString(R.string.dont_have_an_account)
        val signUp = getString(R.string.sign_up)
        val spannable = SpannableString(haveAccount)
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary)), haveAccount.length - signUp.length, haveAccount.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        dontHaveAccount.setText(spannable, TextView.BufferType.SPANNABLE)
    }
}

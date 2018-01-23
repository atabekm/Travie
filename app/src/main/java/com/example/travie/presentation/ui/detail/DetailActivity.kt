package com.example.travie.presentation.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import com.example.travie.R
import com.example.travie.domain.model.Transaction
import com.example.travie.util.dayText
import com.example.travie.util.getCurrencyText
import com.example.travie.util.monthText
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by atabek on 01/23/2018.
 */

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val transaction = intent.getSerializableExtra("t") as Transaction

        detailsDate.text = transaction.date.dayText().plus(" ").plus(transaction.date.monthText())
        detailsPrice.text = transaction.amount.getCurrencyText()
        detailsTitle.text = transaction.title
        detailsCategory1.text = transaction.categories[0].title

        if (transaction.categories.size == 2) {
            detailsCategory2.visibility = VISIBLE
            detailsCategory2.text = transaction.categories[1].title
        }
    }
}
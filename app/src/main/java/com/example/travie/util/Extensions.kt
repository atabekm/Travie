package com.example.travie.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by atabek on 01/21/2018.
 */

fun Date.day(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DAY_OF_MONTH)
}

fun Date.month(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.MONTH)
}

fun Date.dayText(): String {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DAY_OF_MONTH).toString()
}

fun Date.monthText(): String {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()).toString()
}

fun Date.headerText(): String {
    return SimpleDateFormat("EEEE d MMM, yyyy", Locale.getDefault()).format(this)
}

fun Double.getCurrencyText(): String {
    return if (this % 1 == 0.0) {
        String.format("$%d", this.toInt())
    } else {
        String.format("$%.2f", this)
    }
}
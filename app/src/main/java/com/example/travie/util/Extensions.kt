package com.example.travie.util

import java.util.*

/**
 * Created by atabek on 01/21/2018.
 */

fun Date.day(): String {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DAY_OF_MONTH).toString()
}

fun Date.month(): String {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()).toString()
}

fun Double.getCurrency(): String {
    return if (this % 1 == 0.0) {
        String.format("$%d", this.toInt())
    } else {
        String.format("$%.2f", this)
    }
}
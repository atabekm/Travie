package com.example.travie.domain.model

import java.io.Serializable
import java.util.*

/**
 * Created by atabek on 01/20/2018.
 */

data class Transaction(val id: Int, val title: String, val categories: List<Category>, val amount: Double, val date: Date): Serializable
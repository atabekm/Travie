package com.example.travie.data.cache

import com.example.travie.domain.model.Category
import com.example.travie.domain.model.Transaction
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * Created by atabek on 01/23/2018.
 */

class CacheServiceTest {
    private val category = Category(1, "category1")
    private val transaction = Transaction(1, "transaction1", listOf(category), 1.0, Date())
    private val transactionList = listOf(transaction)
    private lateinit var service: CacheService

    @Before
    fun setUp() {
        service = CacheService()
    }

    @Test
    fun shouldReturnInvalidIfNotInitialisedYet() {
        Assert.assertFalse(service.isValid(1L))
    }

    @Test
    fun shouldReturnEmptyTransactionsIfNotInitialisedYet() {
        Assert.assertEquals(service.getTransactions().size, 0)
    }

    @Test
    fun shouldReturnInvalidIfInitialisedAndMoreThan5MinutesPassed() {
        val time = Date().time - 6 * 60 * 1000
        service.set(time, transactionList)
        Assert.assertFalse(service.isValid(Date().time))
    }

    @Test
    fun shouldReturnValidIfInitialisedAndLessThan5MinutesPassed() {
        val time = Date().time - 4 * 60 * 1000
        service.set(time, transactionList)
        Assert.assertTrue(service.isValid(Date().time))
    }


}
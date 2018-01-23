package com.example.travie.presentation.ui.recent

import com.example.travie.TestSchedulers
import com.example.travie.domain.interactor.CacheTransactionsUseCase
import com.example.travie.domain.interactor.GetTransactionsUseCase
import com.example.travie.domain.model.Category
import com.example.travie.domain.model.Transaction
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.*

/**
 * Created by atabek on 01/24/2018.
 */
class RecentTransactionsPresenterTest {

    @Mock private lateinit var getTransactionsUseCase: GetTransactionsUseCase
    @Mock private lateinit var cacheTransactionsUseCase: CacheTransactionsUseCase
    @Mock private lateinit var view: RecentTransactionsView

    private lateinit var presenter: RecentTransactionsPresenter
    private val scheduler = TestSchedulers()
    private val category = Category(1, "category1")
    private val transaction = Transaction(1, "transaction1", listOf(category), 1.0, Date())
    private val transactionList = listOf(transaction)
    private val errorMessage = "Some error message"
    private val throwable = Throwable(errorMessage)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = RecentTransactionsPresenter(getTransactionsUseCase, cacheTransactionsUseCase, scheduler)
        presenter.init(view)
    }

    @Test
    fun shouldReturnRecentTransactions() {
        whenever(getTransactionsUseCase.execute()).thenReturn(Single.just(transactionList))
        whenever(cacheTransactionsUseCase.execute(transactionList)).thenReturn(Completable.complete())
        presenter.getRecentTransactions()
        verify(view, times(1)).showProgressBar(true)
        verify(getTransactionsUseCase, times(1)).execute()
        verify(cacheTransactionsUseCase, times(1)).execute(transactionList)
        verify(view, times(1)).updateTransactions(TransactionConverter.toWrapper(transactionList))
        verify(view, times(1)).showProgressBar(false)
    }

    @Test
    fun shouldReturnError() {
        whenever(getTransactionsUseCase.execute()).thenReturn(Single.error(throwable))
        presenter.getRecentTransactions()
        verify(view, times(1)).showProgressBar(true)
        verify(getTransactionsUseCase, times(1)).execute()
        verify(view, times(1)).showProgressBar(false)
        verify(view, times(1)).showErrorMessage(errorMessage)
    }

}
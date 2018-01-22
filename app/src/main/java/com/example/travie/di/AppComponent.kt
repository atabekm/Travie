package com.example.travie.di

import com.example.travie.TravieApp
import com.example.travie.di.module.AppModule
import com.example.travie.di.module.DataModule
import com.example.travie.di.module.DomainModule
import com.example.travie.presentation.ui.recent.RecentTransactionsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by atabek on 01/21/2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, DomainModule::class))
interface AppComponent {
    fun inject(app: TravieApp)
    fun inject(fragment: RecentTransactionsFragment)
}
package com.example.travie

import android.app.Application
import com.example.travie.di.AppComponent
import com.example.travie.di.DaggerAppComponent
import com.example.travie.di.module.AppModule

/**
 * Created by atabek on 01/21/2018.
 */

class TravieApp: Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}
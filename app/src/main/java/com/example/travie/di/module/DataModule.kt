package com.example.travie.di.module

import com.example.travie.data.network.TravieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by atabek on 01/21/2018.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.myjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit) = retrofit.create(TravieService::class.java)

}
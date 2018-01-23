package com.example.travie

import com.example.travie.di.scheduler.SchedulerProvider
import io.reactivex.schedulers.Schedulers

/**
 * Created by atabek on 01/24/2018.
 */

class TestSchedulers : SchedulerProvider {
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}
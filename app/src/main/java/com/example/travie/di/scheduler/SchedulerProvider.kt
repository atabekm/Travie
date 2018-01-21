package com.example.travie.di.scheduler

import io.reactivex.Scheduler

/**
 * Created by atabek on 01/21/2018.
 */

interface SchedulerProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
}
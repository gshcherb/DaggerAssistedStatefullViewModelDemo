package com.example.daggerassistedstatefullviewmodeldemo.di.app

import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun randomLong(): Long = 0
}
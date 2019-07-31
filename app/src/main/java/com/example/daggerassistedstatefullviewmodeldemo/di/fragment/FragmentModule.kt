package com.example.daggerassistedstatefullviewmodeldemo.di.fragment

import com.example.daggerassistedstatefullviewmodeldemo.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun mainFragment(): MainFragment

}

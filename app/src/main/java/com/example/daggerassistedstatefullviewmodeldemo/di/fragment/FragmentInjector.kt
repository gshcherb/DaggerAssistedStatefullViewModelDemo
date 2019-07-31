package com.example.daggerassistedstatefullviewmodeldemo.di.fragment

import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class FragmentInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var fragment: Fragment
    
    fun inject() {
        androidInjector.inject(fragment)
    }
}

package com.example.daggerassistedstatefullviewmodeldemo

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.daggerassistedstatefullviewmodeldemo.di.AppDependencies
import com.example.daggerassistedstatefullviewmodeldemo.di.app.AppComponent
import com.example.daggerassistedstatefullviewmodeldemo.di.app.DaggerAppComponent
import com.example.daggerassistedstatefullviewmodeldemo.di.fragment.injectFragment

class DemoApplication : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appDependencies(object : AppDependencies {
                override fun dependency() = "dependency"
            })
            .build()
    }

    fun inject(fragment: Fragment) {
        appComponent
            .fragmentComponent()
            .fragment(fragment)
            .build()
            .injectFragment()
    }
}
package com.example.daggerassistedstatefullviewmodeldemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    override fun androidInjector() = AndroidInjector<Any> { instance ->
        (applicationContext as DemoApplication).inject(instance as Fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.run { return }

        supportFragmentManager.commitNow {
            add(android.R.id.content, MainFragment())
        }
    }
}

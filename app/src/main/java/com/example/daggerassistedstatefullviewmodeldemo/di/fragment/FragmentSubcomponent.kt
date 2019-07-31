package com.example.daggerassistedstatefullviewmodeldemo.di.fragment

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Subcomponent(
    modules = [
        AndroidSupportInjectionModule::class,
        FragmentViewModelFactoryModule::class,
        FragmentModule::class
    ]
)
abstract class FragmentSubcomponent : AndroidInjector<FragmentInjector> {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment: Fragment): Builder

        fun build(): AndroidInjector<FragmentInjector>
    }
}


fun AndroidInjector<FragmentInjector>.injectFragment() {
    object : FragmentInjector() {
        init {
            // inject holder by AndroidInjector<FragmentInjector>
            inject(this)
            // inject fragment by FragmentInjector
            inject()
        }
    }
}

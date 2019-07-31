package com.example.daggerassistedstatefullviewmodeldemo.di.app

import com.example.daggerassistedstatefullviewmodeldemo.di.AppDependencies
import com.example.daggerassistedstatefullviewmodeldemo.di.fragment.FragmentSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ],
    dependencies = [AppDependencies::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun appDependencies(appDependencies: AppDependencies): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }

    fun fragmentComponent(): FragmentSubcomponent.Builder
}



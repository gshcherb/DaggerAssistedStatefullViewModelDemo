package com.example.daggerassistedstatefullviewmodeldemo.di.app

import androidx.lifecycle.ViewModel
import com.example.daggerassistedstatefullviewmodeldemo.MainViewModel
import com.example.daggerassistedstatefullviewmodeldemo.di.ViewModelAssistedFactory
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

typealias AssistedFactory = ViewModelAssistedFactory<out ViewModel>

@AssistedModule
@Module(includes = [AssistedInject_ViewModelModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(viewModel: MainViewModel.Factory): AssistedFactory
}
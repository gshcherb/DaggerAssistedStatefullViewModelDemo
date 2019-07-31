package com.example.daggerassistedstatefullviewmodeldemo.di.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerassistedstatefullviewmodeldemo.di.app.AssistedFactory
import dagger.Module
import dagger.Provides

@Module
class FragmentViewModelFactoryModule {

    @Provides
    fun viewModelFactory(
        fragment: Fragment,
        viewModels: @JvmSuppressWildcards Map<Class<out ViewModel>, AssistedFactory>
    ): ViewModelProvider.Factory {
        return object : AbstractSavedStateViewModelFactory(fragment, null) {
            override fun <T : ViewModel> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                @Suppress("UNCHECKED_CAST")
                return viewModels.getValue(modelClass).create(handle) as T
            }
        }
    }
}
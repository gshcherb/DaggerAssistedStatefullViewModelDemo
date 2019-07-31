package com.example.daggerassistedstatefullviewmodeldemo.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<T : ViewModel> {
    fun create(savedState: SavedStateHandle): T
}

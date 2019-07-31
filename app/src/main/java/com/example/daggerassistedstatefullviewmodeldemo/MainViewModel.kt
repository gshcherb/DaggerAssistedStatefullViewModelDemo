package com.example.daggerassistedstatefullviewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.daggerassistedstatefullviewmodeldemo.di.ViewModelAssistedFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class MainViewModel @AssistedInject constructor(
    private val dependency: String,
    @Assisted val savedState: SavedStateHandle
) : ViewModel() {

    companion object {
        const val KEY_COUNTER = "counter"
    }

    private var inc = savedState.get<Int>(KEY_COUNTER) ?: 0

    val incLiveData = MutableLiveData<String>()

    init {
        sendState()
    }

    private fun sendState() {
        incLiveData.value = "$dependency $inc"
    }

    fun increment() {
        inc++
        savedState.set(KEY_COUNTER, inc)
        sendState()
    }

    @AssistedInject.Factory
    interface Factory : ViewModelAssistedFactory<MainViewModel>
}
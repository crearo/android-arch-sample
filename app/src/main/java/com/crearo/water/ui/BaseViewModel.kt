package com.crearo.water.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    protected val _navigation = MutableLiveData<NavEvent<NavDirections>>()
    val navigation: LiveData<NavEvent<NavDirections>> = _navigation
}

class NavEvent<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getNavIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

package com.crearo.water.ui.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crearo.water.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class UiState(var buttonText: String)

@HiltViewModel
class PermissionsViewModel @Inject constructor() : BaseViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    init {
        loadUi()
    }

    fun onButtonClick() {

    }

    fun navigateIfComplete() {

    }

    fun loadUi() {
        _uiState.value = UiState(buttonText = getButtonText())
    }

    private fun getButtonText(): String {
        return "Grant"
    }

}
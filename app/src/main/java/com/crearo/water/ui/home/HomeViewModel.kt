package com.crearo.water.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crearo.water.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UiState(
    var restrictedApps: String
)

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    init {
        CoroutineScope(Dispatchers.Main).launch {
            _uiState.value = UiState("None")
        }
    }

}
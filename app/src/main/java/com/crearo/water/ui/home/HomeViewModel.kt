package com.crearo.water.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.crearo.water.repo.intro.IntroRepo
import com.crearo.water.ui.BaseViewModel
import com.crearo.water.ui.NavEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class UiState(
    var title: String
)

@HiltViewModel
class HomeViewModel @Inject constructor(private val introRepo: IntroRepo) : BaseViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = UiState("Good Afternoon")
        }
    }

    fun onResetClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            introRepo.reset()
            withContext(Dispatchers.Main) {
                _navigation.value =
                    NavEvent(HomeFragmentDirections.actionHomeFragmentToIntroFragment())
            }
        }
    }

}
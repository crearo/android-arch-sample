package com.crearo.water.ui.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.crearo.water.repo.intro.IntroRepo
import com.crearo.water.ui.BaseViewModel
import com.crearo.water.ui.NavEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class UiState(val stage: IntroViewModel.Stage)

@HiltViewModel
class IntroViewModel @Inject constructor(private val introRepo: IntroRepo) : BaseViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    private var stageInt: Int = 1

    init {
        viewModelScope.launch {
            introRepo.getStage().collect { newStage ->
                run {
                    stageInt = newStage
                    if (newStage == 4) {
                        _navigation.value =
                            NavEvent(IntroFragmentDirections.actionIntroFragmentToHomeFragment())
                    } else {
                        val stage = Stage.get(newStage)
                        _uiState.value = UiState(stage)
                    }
                }
            }
        }
    }

    fun proceedStage() {
        viewModelScope.launch(Dispatchers.IO) {
            introRepo.setStage(stageInt + 1)
        }
    }

    enum class Stage(val number: Int, val title: String, val action: String) {
        /**First*/
        FIRST(1, "First Title", "Proceed"),

        /**Second*/
        SECOND(2, "Second Title", "Again"),

        /**Third*/
        THIRD(3, "Third Title", "Done");

        companion object {
            fun get(number: Int): Stage {
                return when (number) {
                    1 -> FIRST
                    2 -> SECOND
                    3 -> THIRD
                    else -> {
                        FIRST
                    }
                }
            }
        }
    }

}
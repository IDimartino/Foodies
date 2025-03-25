package com.foodies.onboarding_presentation.name

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodies.core.domain.preferences.Preferences
import com.foodies.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var selectedName by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onNameChange(name: String) {
        selectedName = name
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveName(selectedName)
            _uiEvent.send(UiEvent.Success)
        }
    }
}
package com.foodies.home_presentation.profile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodies.core.domain.model.UserInfo
import com.foodies.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {
    private val _userInfo = MutableStateFlow<UserInfo?>(null)
    val userInfo = _userInfo.asStateFlow()

    init {
        loadUserInfo()
    }

    private fun loadUserInfo() {
        viewModelScope.launch {
            _userInfo.value = preferences.loadUserInfo()
        }
    }
}
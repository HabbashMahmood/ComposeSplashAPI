package com.habbashmahmood.compose_splash_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashScreenViewModel: ViewModel() {

    private val _sync = MutableStateFlow(true)
    val sync = _sync.asStateFlow()

    init {
        viewModelScope.launch {
            // emulating server request with delay
            delay(2000)
            _sync.value = false
        }
    }
}
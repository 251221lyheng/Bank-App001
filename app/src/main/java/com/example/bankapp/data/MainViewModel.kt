package com.example.bankapp.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    // State for TopAppBar
    var showDialogContent by mutableStateOf(false)
        private set

    fun toggleDialog() {
        showDialogContent = !showDialogContent
    }

    fun closeDialog() {
        showDialogContent = false
    }

    // State for NewInformation
    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    val itemSlider = listOf(
        R.drawable.slider1, // Replace with actual drawable resource IDs
        R.drawable.slider2,
        R.drawable.slider3
    )

    init {
        viewModelScope.launch {
            while (true) {
                delay(3000) // Adjust the delay as needed (e.g., 3000 ms = 3 seconds)
                _currentIndex.value = (_currentIndex.value + 1) % itemSlider.size
            }
        }
    }
}

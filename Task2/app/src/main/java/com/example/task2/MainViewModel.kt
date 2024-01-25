package com.example.task2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainViewModel: ViewModel() {
    var uiState = MutableStateFlow(TaskUIState())
}
data class TaskUIState(
    var emailOrPhoneNumber: String = "",
    var password: String = ""
)
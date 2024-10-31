package com.example.flash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlashViewModel:ViewModel() {
    private val _uistate = MutableStateFlow(FlashUiState())
    val uiState :StateFlow<FlashUiState> = _uistate.asStateFlow()

    val _isVisible = MutableStateFlow(true)
    val isVisible = _isVisible

    fun updateClickText(updatedText: String){
        _uistate.update {
            it.copy(
                clickStatus = updatedText
            )
        }
    }

    fun updateSelectedCategory(updateCategory: Int){
        _uistate.update {
            it.copy(
                selectedCategory = updateCategory
            )
        }
    }

    fun toggleVisibility(){
        _isVisible.value = false
    }

    init {
        viewModelScope.launch(Dispatchers.Default){
            kotlinx.coroutines.delay(3000)
            toggleVisibility()
        }
    }
}
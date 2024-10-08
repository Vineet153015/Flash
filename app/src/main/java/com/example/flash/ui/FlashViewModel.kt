package com.example.flash.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlashViewModel:ViewModel() {
    private val _uistate = MutableStateFlow(FlashUiState())
    val uiState :StateFlow<FlashUiState> = _uistate.asStateFlow()

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
}
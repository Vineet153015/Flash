package com.example.flash.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ItemsScreen(flashViewModel: FlashViewModel){
    val flashUiState by flashViewModel.uiState.collectAsState()
    Text(text = flashUiState.selectedCategory)
}
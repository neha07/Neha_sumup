package com.sumup.challenge.toastcatalog.ui.items.state

import com.sumup.challenge.toastcatalog.data.model.Item

sealed class ItemUiState {
    object Loading : ItemUiState() // Represents loading state
    data class Success(val items: List<Item>) : ItemUiState() // Represents success state with data
    data class Error(val message: String) : ItemUiState() // Represents error state with a message
}
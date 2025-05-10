package com.sumup.challenge.toastcatalog.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.domain.ItemRepository
import com.sumup.challenge.toastcatalog.ui.items.state.ItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    // MutableLiveData to track UI states
    private val _uiState = MutableLiveData<ItemUiState>(ItemUiState.Loading)
    val uiState: LiveData<ItemUiState> get() = _uiState // Expose UI state as LiveData

    // Function to load items from repository
    fun loadItems() {
        viewModelScope.launch {
            _uiState.value = ItemUiState.Loading // Set loading state

            try {
                val items = repository.fetchItems() // Fetch items from repository
                _uiState.value = ItemUiState.Success(items) // Set success state with fetched items
            } catch (e: Exception) {
                _uiState.value = ItemUiState.Error("Failed to load items") // Set error state if fetching fails
            }
        }
    }
}
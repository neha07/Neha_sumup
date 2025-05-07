package com.sumup.challenge.toastcatalog.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.data.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {

    private val repository = ItemRepository()
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    fun loadItems() {
        viewModelScope.launch {
            try {
                _items.value = repository.fetchItems()
            } catch (e: Exception) {
                _items.value = emptyList()
            }
        }
    }

}
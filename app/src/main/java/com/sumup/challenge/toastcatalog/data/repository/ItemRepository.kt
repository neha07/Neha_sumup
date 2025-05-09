package com.sumup.challenge.toastcatalog.data.repository

import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.data.network.ItemApiService
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val apiService: ItemApiService
) {
    suspend fun fetchItems(): List<Item> {
        return try {
            apiService.getItems()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
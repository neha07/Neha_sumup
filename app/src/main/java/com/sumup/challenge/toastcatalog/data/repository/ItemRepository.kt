package com.sumup.challenge.toastcatalog.data.repository

import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.data.network.NetworkClient
import com.sumup.challenge.toastcatalog.data.network.NetworkClientProvider

class ItemRepository {
    private val apiService = NetworkClientProvider.instance.apiService

    suspend fun fetchItems(): List<Item> {
        return try {
            apiService.getItems()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
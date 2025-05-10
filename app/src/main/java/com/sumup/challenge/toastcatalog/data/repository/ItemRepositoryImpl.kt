package com.sumup.challenge.toastcatalog.data.repository

import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.data.network.ItemApiService
import com.sumup.challenge.toastcatalog.domain.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val apiService: ItemApiService
): ItemRepository {
    override suspend fun fetchItems(): List<Item> {
        return try {
            apiService.getItems()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
package com.sumup.challenge.toastcatalog.fake

import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.domain.ItemRepository

class FakeRepository(private val mockData: List<Item> = emptyList()) : ItemRepository {
    override suspend fun fetchItems(): List<Item> = mockData
}
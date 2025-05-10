package com.sumup.challenge.toastcatalog.domain

import com.sumup.challenge.toastcatalog.data.model.Item

interface ItemRepository {
    suspend fun fetchItems(): List<Item>
}
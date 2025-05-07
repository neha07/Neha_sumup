package com.sumup.challenge.toastcatalog.data.network

import com.sumup.challenge.toastcatalog.data.model.Item
import retrofit2.http.GET

interface ItemApiService {
    @GET("items")
    suspend fun getItems(): List<Item>
}
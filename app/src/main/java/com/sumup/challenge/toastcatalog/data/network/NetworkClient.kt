package com.sumup.challenge.toastcatalog.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient(private val baseUrl: String = DEFAULT_BASE_URL) {

    companion object {
        private const val DEFAULT_BASE_URL =
            "https://my-json-server.typicode.com/sumup-challenges/mobile-coding-challenge-data/"
    }

    val apiService: ItemApiService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemApiService::class.java)
    }

}

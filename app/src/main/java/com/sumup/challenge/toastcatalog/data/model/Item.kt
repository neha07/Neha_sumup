package com.sumup.challenge.toastcatalog.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    val id: Int,
    val name: String,
    val price: String,
    val currency: String,
    @SerializedName("last_sold")
    val lastSold: String
)

package com.dfl.comunicationdriveserver.data.data_source.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataProducts(
    val data: Products
)

@Serializable
data class Products(
    @SerializedName(value = "request_id")
    val id: String,
    val products: List<DataProduct>
)

@Serializable
data class DataProduct(
    val type: String,
    val name: String,
    val number: String,
    @SerializedName(value = "available_balance")
    val balance: Long,
    val status: String
)
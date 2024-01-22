package com.dfl.comunicationdriveserver.data.data_source.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataProductDelivery(
    @SerialName(value = "request_id")
    val id: String,
    @SerialName(value = "next_step")
    val next: String
)

@Serializable
data class ProductsDelivery(
    @SerialName(value = "request_id")
    val id: String,
    val product: DataProduct
)
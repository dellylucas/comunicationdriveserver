package com.dfl.comunicationdriveserver.domain.model

data class ProductModel(
    val type: String,
    val name: String,
    val number: String,
    val balance: Long,
    val status: String
)


data class MainProducts(
    val id: String,
    val products: List<ProductModel>
)
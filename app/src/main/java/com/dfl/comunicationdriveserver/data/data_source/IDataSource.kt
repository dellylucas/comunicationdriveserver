package com.dfl.comunicationdriveserver.data.data_source

import com.dfl.comunicationdriveserver.domain.model.DeliveryModel
import com.dfl.comunicationdriveserver.domain.model.MainProducts
import com.dfl.comunicationdriveserver.domain.model.ProductModel

interface IDataSource {
    suspend fun getProducts(): MainProducts
    suspend fun sendDelivery(id: String, productModel: ProductModel): DeliveryModel
}
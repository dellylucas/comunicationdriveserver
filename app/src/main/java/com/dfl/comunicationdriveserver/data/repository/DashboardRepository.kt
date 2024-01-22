package com.dfl.comunicationdriveserver.data.repository

import com.dfl.comunicationdriveserver.data.data_source.IDataSource
import com.dfl.comunicationdriveserver.domain.model.ProductModel

class DashboardRepository(private val iDataSource: IDataSource) {

    suspend fun getProducts() = iDataSource.getProducts()

    suspend fun sendDelivery(id: String, productModel: ProductModel) = iDataSource.sendDelivery(id,productModel)


}
package com.dfl.comunicationdriveserver.data.data_source

import com.dfl.comunicationdriveserver.data.data_source.model.ProductsDelivery
import com.dfl.comunicationdriveserver.data.mapper.DTOProduct.getModel
import com.dfl.comunicationdriveserver.data.mapper.OTDProduct.getModel
import com.dfl.comunicationdriveserver.domain.model.ProductModel
import retrofit2.Retrofit

class RemoteDataSource(retrofit: Retrofit) : IDataSource {

    private val retrofitService: ProductDashboardService by lazy {
        retrofit.create(ProductDashboardService::class.java)
    }

    override suspend fun getProducts() = retrofitService.getProducts().data.getModel()

    override suspend fun sendDelivery(id: String, productModel: ProductModel) =
        retrofitService.sendDelivery(
            ProductsDelivery(id, productModel.getModel())
        ).getModel()
}
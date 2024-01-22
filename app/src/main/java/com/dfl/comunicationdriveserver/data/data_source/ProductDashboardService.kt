package com.dfl.comunicationdriveserver.data.data_source

import com.dfl.comunicationdriveserver.data.data_source.model.DataProductDelivery
import com.dfl.comunicationdriveserver.data.data_source.model.DataProducts
import com.dfl.comunicationdriveserver.data.data_source.model.ProductsDelivery
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductDashboardService {

    @GET("products")
    suspend fun getProducts(): DataProducts

    @POST("dashboard-delivery")
    @FormUrlEncoded
    suspend fun sendDelivery(@Body productsDelivery: ProductsDelivery): DataProductDelivery
}
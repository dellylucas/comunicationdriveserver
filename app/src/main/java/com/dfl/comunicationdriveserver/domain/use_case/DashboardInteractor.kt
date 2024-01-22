package com.dfl.comunicationdriveserver.domain.use_case

import com.dfl.comunicationdriveserver.data.repository.DashboardRepository
import com.dfl.comunicationdriveserver.domain.model.ProductModel

class DashboardInteractor(private val repository: DashboardRepository) {

    suspend fun getInformation() =
        repository.getProducts()

    suspend fun sendDelivery(id: String, productModel: ProductModel) =
        repository.sendDelivery(id,productModel)

}
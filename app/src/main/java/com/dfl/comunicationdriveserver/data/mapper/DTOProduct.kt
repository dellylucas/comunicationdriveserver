package com.dfl.comunicationdriveserver.data.mapper

import com.dfl.comunicationdriveserver.data.data_source.model.DataProductDelivery
import com.dfl.comunicationdriveserver.data.data_source.model.Products
import com.dfl.comunicationdriveserver.domain.model.DeliveryModel
import com.dfl.comunicationdriveserver.domain.model.MainProducts
import com.dfl.comunicationdriveserver.domain.model.ProductModel

object DTOProduct {
    fun Products.getModel(): MainProducts = MainProducts(id, products.map { data ->
        ProductModel(
            data.type,
            data.name,
            data.number,
            data.balance,
            data.status
        )
    })

    fun DataProductDelivery.getModel(): DeliveryModel = DeliveryModel(id, next)
}
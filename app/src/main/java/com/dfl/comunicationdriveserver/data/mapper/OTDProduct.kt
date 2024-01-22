package com.dfl.comunicationdriveserver.data.mapper

import com.dfl.comunicationdriveserver.data.data_source.model.DataProduct
import com.dfl.comunicationdriveserver.domain.model.ProductModel

object OTDProduct {
    fun ProductModel.getModel(): DataProduct = DataProduct(type, name, number, balance, status)
}
package com.data.list

import com.domain.product.ProductListRepository
import com.domain.product.result.ProductList
import javax.inject.Inject

class ProductListRepositoryImpl@Inject constructor(private val api: ProductListApi): ProductListRepository {
    override suspend fun getList(): List<ProductList> {
        val productList = api.getList()
        return productList.sortedBy { it.price.toDoubleOrNull() ?: Double.MAX_VALUE }
    }
}
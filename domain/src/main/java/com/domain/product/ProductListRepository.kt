package com.domain.product

import com.domain.product.result.ProductList

interface ProductListRepository {
    suspend fun getList(): List<ProductList>
}
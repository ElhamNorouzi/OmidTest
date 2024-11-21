package com.data.list

import com.domain.product.result.ProductList
import retrofit2.http.GET

interface ProductListApi {
    @GET("products")
    suspend fun getList(): List<ProductList>
}
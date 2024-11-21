package com.domain.product.usecase

import com.domain.product.ProductListRepository
import com.domain.product.result.ProductList
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(private val repository: ProductListRepository) {
    suspend operator fun invoke(): List<ProductList> = repository.getList()
}
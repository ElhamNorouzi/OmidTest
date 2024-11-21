package com.domain.product.result

data class ProductList(
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val image: String,
    val description: String
)
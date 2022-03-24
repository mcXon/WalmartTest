package com.example.walmarttest.model

data class ProductResponse(
    val products: List<ProductItems>
)

data class ProductItems(
    val productName: String,
    val longDescription: String
)

package com.example.products.model

import com.example.products.model.Product

data class ProductsResponse(
    val products: List<Product>,
    val total:Int,
    val skip:Int,
    val limit:Int,
)

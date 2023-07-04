package com.example.products.api

import com.example.products.model.Product
import com.example.products.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts():Response<ProductsResponse>
    @GET("/products/{id}")
    suspend fun getProducts(@Path("id")productId:Int):Response<Product>

}
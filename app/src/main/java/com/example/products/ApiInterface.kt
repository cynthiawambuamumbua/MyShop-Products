package com.example.products

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    fun getProducts():Call<ProductsResponse>
}
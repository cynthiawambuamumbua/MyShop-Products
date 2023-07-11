package com.example.products.api

import com.example.products.model.Comments
import com.example.products.model.CommentsResponse
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

    @GET("/comment")
    suspend fun getComments(): Response<CommentsResponse>
    @GET("/comments/{id}")
    suspend fun getComments(@Path("id")commentsId:Int): Response<Comments>


}
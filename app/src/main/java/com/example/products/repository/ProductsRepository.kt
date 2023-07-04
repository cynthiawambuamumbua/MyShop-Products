package com.example.products.repository

import com.example.products.api.ApiClients
import com.example.products.api.ApiInterface
import com.example.products.model.ProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductsRepository {
    val apiClient=ApiClients.buildClients(ApiInterface::class.java)

    suspend fun getProducts():Response<ProductsResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }

    }
}
package com.example.comments.repository

import com.example.products.api.ApiClients
import com.example.products.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class commentsRepository {
    val apiClient= ApiClients.buildClients(ApiInterface::class.java)

    suspend fun getComments(){
        return withContext(Dispatchers.IO){
            apiClient.getComments()
        }

    }
}
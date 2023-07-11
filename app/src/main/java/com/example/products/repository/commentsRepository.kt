package com.example.comments.repository

import com.example.products.api.ApiClients
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class commentsRepository {
    val apiClient= ApiClients.buildClients(ApiInterface2::class.java)

    suspend fun getComments(){
        return withContext(Dispatchers.IO){
            apiClient.getComments()
        }

    }
}
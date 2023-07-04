package com.example.products.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClients{
    var retrofit=Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildClients(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
}
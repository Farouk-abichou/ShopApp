package com.example.shopapp.network

import com.example.shopapp.model.Product
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ProductApi {
    @GET("products")
    suspend fun getAllProducts():Product
}
package com.example.shopapp.network

import com.example.shopapp.model.Product
import com.example.shopapp.model.ProductItem
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ProductApi {
    @GET("products")
    suspend fun getAllProducts():Product


}
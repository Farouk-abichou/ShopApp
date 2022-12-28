package com.example.shopapp.network

import com.example.shopapp.model.ProductItem
import com.example.shopapp.model.Products
import com.example.shopapp.model.Users
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ProductApi {
    @GET("products")
    suspend fun getAllProducts():Products

    @GET("users")
    suspend fun getAllUsers(): Users

    @GET("carts")
    suspend fun getAllCartProducts():Products

    @GET("products")
    suspend fun getProductById(@Query("id") id:Int):List<ProductItem>

}
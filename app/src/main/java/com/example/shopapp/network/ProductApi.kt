package com.example.shopapp.network

import com.example.shopapp.model.cartModels.Cart
import com.example.shopapp.model.productModels.Categories
import com.example.shopapp.model.productModels.ProductItem
import com.example.shopapp.model.productModels.Products
import com.example.shopapp.model.userModels.Users
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface ProductApi {
    @GET("products")
    suspend fun getAllProducts(): Products

    @GET("carts")
    suspend fun getAllCartItems():Cart

    @GET("products/categories")
    suspend fun getAllCategories(): Categories




    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id:Int): ProductItem

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(@Path("category") category:String) : Products

}
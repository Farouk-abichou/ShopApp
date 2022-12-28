package com.example.shopapp.repository


import android.util.Log
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.ProductItem
import com.example.shopapp.model.Rating
import com.example.shopapp.model.User
import com.example.shopapp.network.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ProductApi) {
    private val productDataOrException
            = DataOrException<ArrayList<ProductItem>,
                Boolean,
                Exception>()

    suspend fun getAllProducts():DataOrException<ArrayList<ProductItem>,Boolean,java.lang.Exception>{
        try {
            productDataOrException.loading = true
            productDataOrException.data = api.getAllProducts()
            if (productDataOrException.data.toString().isNotEmpty()) {
                productDataOrException.loading = false
            }
        }catch (exception:Exception){
            productDataOrException.e = exception
        }
        return productDataOrException
    }

    private val userDataOrException
            = DataOrException<ArrayList<User>,
            Boolean,
            Exception>()

    suspend fun getAllUsers():DataOrException<ArrayList<User>,Boolean,java.lang.Exception>{
        try {
            userDataOrException.loading = true
            userDataOrException.data = api.getAllUsers()
            if (userDataOrException.data.toString().isNotEmpty()) {
                userDataOrException.loading = false
            }
        }catch (exception:Exception){
            userDataOrException.e = exception
        }
        return userDataOrException
    }

    private val cartDataOrException
            = DataOrException<ArrayList<ProductItem>,
            Boolean,
            Exception>()

    suspend fun getAllCartProducts():DataOrException<ArrayList<ProductItem>,Boolean,java.lang.Exception>{
        try {
            cartDataOrException.loading = true
            cartDataOrException.data = api.getAllCartProducts()
            if (cartDataOrException.data.toString().isNotEmpty()) {
                cartDataOrException.loading = false
            }
        }catch (exception:Exception){
            cartDataOrException.e = exception
        }
        return cartDataOrException
    }



     var productById=  listOf( ProductItem(0,"",0.0f,"","", Rating(0f,0)))

    suspend fun getProductById2(id: Int): List<ProductItem> {
        try {
             productById= api.getProductById(id)

        }catch (exception:Exception){
            productDataOrException.e = exception
        }
        return productById
    }




}




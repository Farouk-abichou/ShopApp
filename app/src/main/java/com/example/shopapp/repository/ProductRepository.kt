package com.example.shopapp.repository


import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.productModels.Categories
import com.example.shopapp.model.productModels.ProductItem
import com.example.shopapp.model.productModels.Rating
import com.example.shopapp.network.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ProductApi) {
    private val productDataOrException
            = DataOrException<ArrayList<ProductItem>,
                Boolean,
                Exception>()

    private val productByCategoryDataOrException
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

    suspend fun getProductsByCategory(category:String):DataOrException<ArrayList<ProductItem>,Boolean,java.lang.Exception>{
        try {
            productByCategoryDataOrException.loading = true
            productByCategoryDataOrException.data = api.getProductsByCategory(category)
            if (productByCategoryDataOrException.data.toString().isNotEmpty()) {
                productByCategoryDataOrException.loading = false
            }
        }catch (exception:Exception){
            productByCategoryDataOrException.e = exception
        }
        return productByCategoryDataOrException
    }


//    private val cartItemsDataOrException
//            = DataOrException<ArrayList<CartItem>,
//            Boolean,
//            Exception>()
//

//    suspend fun getCartProducts():DataOrException<ArrayList<CartItem>,Boolean,java.lang.Exception>{
//        try {
//            cartItemsDataOrException.data = api.getAllCartItems()
//
//        }catch (exception:Exception){
//            cartItemsDataOrException.e = exception
//        }
//        return cartItemsDataOrException
//    }























    var productById=  ProductItem(0,"",0.0f,"","", Rating(0f,0))

    suspend fun getProductById(id: Int): ProductItem {
        try {
            productById= api.getProductById(id)

        }catch (exception:Exception){
            productDataOrException.e = exception
        }
        return productById
    }


    private var categories: Categories = Categories()

    suspend fun getAllCategories(): Categories {
        categories = api.getAllCategories()

        return categories
    }






//    private val userDataOrException
//            = DataOrException<ArrayList<User>,
//            Boolean,
//            Exception>()

//    suspend fun getAllUsers():DataOrException<ArrayList<User>,Boolean,java.lang.Exception>{
//        try {
//            userDataOrException.loading = true
//            userDataOrException.data = api.getAllUsers()
//            if (userDataOrException.data.toString().isNotEmpty()) {
//                userDataOrException.loading = false
//            }
//        }catch (exception:Exception){
//            userDataOrException.e = exception
//        }
//        return userDataOrException
//    }
//
//    private val cartDataOrException
//            = DataOrException<ArrayList<ProductItem>,
//            Boolean,
//            Exception>()
//
//    suspend fun getAllCartProducts():DataOrException<ArrayList<ProductItem>,Boolean,java.lang.Exception>{
//        try {
//            cartDataOrException.loading = true
//            cartDataOrException.data = api.getAllCartItems()
//            if (cartDataOrException.data.toString().isNotEmpty()) {
//                cartDataOrException.loading = false
//            }
//        }catch (exception:Exception){
//            cartDataOrException.e = exception
//        }
//        return cartDataOrException
//    }







}




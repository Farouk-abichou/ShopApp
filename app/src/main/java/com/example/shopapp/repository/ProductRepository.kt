package com.example.shopapp.repository


import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.ProductItem
import com.example.shopapp.network.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ProductApi) {
    private val dataOrException
            = DataOrException<ArrayList<ProductItem>,
                Boolean,
                Exception>()

    suspend fun getAllProducts():DataOrException<ArrayList<ProductItem>,Boolean,java.lang.Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllProducts()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        }catch (exception:Exception){
            dataOrException.e = exception
        }
        return dataOrException


    }
    fun getProductById(id:Int):ProductItem{
        return dataOrException.data!![id]
    }

    fun searchByTitle(title:String) {
        for (product in dataOrException.data!!){
            if (title == product.title){

            }
        }
    }

}




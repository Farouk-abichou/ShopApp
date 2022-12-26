package com.example.shopapp.repository

import android.util.Log
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
                Log.d("tag","getAllQuestions : ${dataOrException.data.toString()}")
            }

        }catch (exception:Exception){
            dataOrException.e = exception
            Log.d("tag","getAllQuestions : ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }



}
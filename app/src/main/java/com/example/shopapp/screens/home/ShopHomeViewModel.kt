package com.example.shopapp.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.productModels.Categories
import com.example.shopapp.model.productModels.ProductItem
import com.example.shopapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class ShopHomeViewModel @Inject constructor(private val repository: ProductRepository)
    : ViewModel() {
    val productData: MutableState<DataOrException<ArrayList<ProductItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception("")) )



    var categories =  Categories()
    var categorySelected:MutableState<String> = mutableStateOf( "")

    var showCategories= mutableStateOf(false)

    init {
        getProducts()
        getAllCategories()
    }

    fun getProducts(): ArrayList<ProductItem>? {
        if (categorySelected.value == ""){
            return getAllProducts()

        }else{
            return getProductsByCategory(categorySelected.value)
        }
    }


    fun getAllProducts():ArrayList<ProductItem>?{
        viewModelScope.launch {
            productData.value.loading =true
            productData.value =repository.getAllProducts()
            if (!productData.value.data.isNullOrEmpty()){
                productData.value.loading =false
            }
        }
        return productData.value.data
    }

     fun getProductsByCategory(category:String): ArrayList<ProductItem>? {
        viewModelScope.launch {
            productData.value = repository.getProductsByCategory(category)

        }
         return productData.value.data
    }

    private fun getAllCategories(){
        viewModelScope.launch {
            categories = repository.getAllCategories()
        }
    }

























//
//    private fun getAllUsers(){
//        viewModelScope.launch {
//            userData.value.loading=true
//            userData.value = repository.getAllUsers()
//            if (userData.value.data.toString().isNotEmpty()){
//                userData.value.loading =false
//                Log.d("users", "${userData.value.data}")
//            }
//        }
//    }
//    private fun getAllCartProducts(){
//        viewModelScope.launch {
//            cartData.value.loading=true
//            cartData.value = repository.getAllCartProducts()
//            if (cartData.value.data.toString().isNotEmpty()){
//                cartData.value.loading =false
//                Log.d("users", "${cartData.value.data}")
//
//            }
//        }
//    }




}
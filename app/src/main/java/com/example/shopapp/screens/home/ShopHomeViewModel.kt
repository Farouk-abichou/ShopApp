package com.example.shopapp.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.ProductItem
import com.example.shopapp.model.User
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

    val userData: MutableState<DataOrException<ArrayList<User>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception("")) )

    val cartData: MutableState<DataOrException<ArrayList<ProductItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception("")) )


    val product =productData.value.data?.toMutableList()

    init {
        getAllProducts()
        getAllUsers()
        getAllCartProducts()
    }
    private fun getAllProducts(){
        viewModelScope.launch {
            productData.value.loading=true
            productData.value = repository.getAllProducts()
            if (productData.value.data.toString().isNotEmpty()){
                productData.value.loading =false
            }
        }
    }

    private fun getAllUsers(){
        viewModelScope.launch {
            userData.value.loading=true
            userData.value = repository.getAllUsers()
            if (userData.value.data.toString().isNotEmpty()){
                userData.value.loading =false
                Log.d("users", "${userData.value.data}")
            }
        }
    }
    private fun getAllCartProducts(){
        viewModelScope.launch {
            cartData.value.loading=true
            cartData.value = repository.getAllCartProducts()
            if (cartData.value.data.toString().isNotEmpty()){
                cartData.value.loading =false
                Log.d("users", "${cartData.value.data}")

            }
        }
    }




}
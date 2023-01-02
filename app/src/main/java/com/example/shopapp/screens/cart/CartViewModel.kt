package com.example.shopapp.screens.cart

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.cartModels.CartItem
import com.example.shopapp.model.productModels.ProductItem
import com.example.shopapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(private val repository: ProductRepository):ViewModel() {


    val cartItemsData: MutableState<DataOrException<ArrayList<CartItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,false,Exception("")) )


    val productData: MutableState<DataOrException<ArrayList<ProductItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,false,Exception("")) )





    val PromoCodeValidation:MutableState<Boolean> = mutableStateOf(false)



    var subTotal= mutableStateOf(0.0)


    init {
        getAllProducts()
        getCartItems()

    }

    fun getCartItems():ArrayList<CartItem>?{
        viewModelScope.launch {
            cartItemsData.value.data =repository.getCartProducts().data
            Log.d("tag7", "${ cartItemsData.value.data }")
        }
        return cartItemsData.value.data
    }


    fun getAllProducts():ArrayList<ProductItem>?{
        viewModelScope.launch {

            productData.value =repository.getAllProducts()

        }
        return productData.value.data
    }

}
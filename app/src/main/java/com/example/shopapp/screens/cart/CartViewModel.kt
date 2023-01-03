package com.example.shopapp.screens.cart

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.CartProduct
import com.example.shopapp.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(private val repository: CartRepository):ViewModel() {

    val cartItemsData: MutableState<DataOrException<List<CartProduct>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,false,Exception("")) )

//    val quantity: MutableState<Int> =
//        mutableStateOf(1)

    val price= mutableStateOf(0.0)

    val finalPrice= mutableStateOf(0.0)

    val promoCodeValidation:MutableState<Boolean> = mutableStateOf(false)

//    var subTotal= mutableStateOf(0.0)

    init {
        getCartProducts()
        getCartProductsFinalPrice()
//        Log.d("tag88", getCartProductsFinalPrice().toString())

    }

    fun getCartProducts(): List<CartProduct>? {
        viewModelScope.launch {
            cartItemsData.value.data = repository.getCartProducts()
        }
        return cartItemsData.value.data
    }

    fun getCartProductsFinalPrice(): Double {
        viewModelScope.launch {
            finalPrice.value = repository.getCartProductsFinalPrice()
        }
        return finalPrice.value
    }

    fun deleteCartProducts(id:Int) {
        viewModelScope.launch {
           repository.deleteCartProduct(id)
        }
    }
}
package com.example.shopapp.screens.cart

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
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
class CartViewModel @Inject constructor(private val repository: ProductRepository, savedStateHandle: SavedStateHandle):ViewModel() {


    val cartItemsData: MutableState<DataOrException<ArrayList<CartItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,false,Exception("")) )

    val PromoCodeValidation:MutableState<Boolean> = mutableStateOf(false)

    var reputationOfProduct= mutableStateOf(2)

    var finalPriceOfOneProduct= mutableStateOf(19.9 * reputationOfProduct.value)

    var subTotal= mutableStateOf(0.0)


    init {

        getCartItems()

    }

    fun getCartItems():ArrayList<CartItem>?{
        viewModelScope.launch {
            cartItemsData.value.data =repository.getCartProducts().data
            Log.d("tag7", "${ cartItemsData.value.data }")
        }
        return cartItemsData.value.data
    }



}
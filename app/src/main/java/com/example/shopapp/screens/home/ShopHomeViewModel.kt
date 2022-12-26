package com.example.shopapp.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.DataOrException
import com.example.shopapp.model.ProductItem
import com.example.shopapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class ShopHomeViewModel @Inject constructor(private val repository: ProductRepository)
    : ViewModel() {
    val data: MutableState<DataOrException<ArrayList<ProductItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception("")) )

    init {
        getAllProducts()
    }

    private fun getAllProducts(){
        viewModelScope.launch {
            data.value.loading=true
            data.value = repository.getAllProducts()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading =false
            }
        }
    }



}
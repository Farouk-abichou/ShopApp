package com.example.shopapp.screens.product

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.model.ProductItem
import com.example.shopapp.model.Rating
import com.example.shopapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository,savedStateHandle: SavedStateHandle)
    :ViewModel() {

    var PrductById= mutableStateOf( repository.productById)


//    val CartItems =  mutableStateOf(ArrayList<ProductItem>())

    private var CurrentproductId:Int=0
    init {

        savedStateHandle.get<String>("Id")?.let { productId ->
            if (productId.toInt() != -1) {
                viewModelScope.launch{
                    repository.getProductById2(productId.toInt()).also { product ->
                        CurrentproductId= productId.toInt()
                        PrductById.value = repository.getProductById2(id = CurrentproductId)
                        Log.d("tagg","${PrductById.value}")

                    }
                }
            }
        }
    }
}
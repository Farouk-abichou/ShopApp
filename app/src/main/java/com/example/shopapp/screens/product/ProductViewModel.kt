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

    val PrductById:MutableState<ProductItem> =
        mutableStateOf(
            ProductItem(0,"text",0f,"text","text", Rating(0f,0))
        )


    private var CurrentproductId:Int=0
    init {

        savedStateHandle.get<String>("Id")?.let { productId ->
            if (productId.toInt() != -1) {
                viewModelScope.launch{
                    repository.getProductById(productId.toInt()).also { product ->
                        CurrentproductId= product.id
                        PrductById.value = repository.getProductById(CurrentproductId-2)
                        Log.d("tag1","$CurrentproductId")
                    }
                }
            }
        }


    }

}
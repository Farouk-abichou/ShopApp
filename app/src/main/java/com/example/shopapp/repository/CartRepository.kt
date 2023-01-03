package com.example.shopapp.repository

import com.example.shopapp.data.CartDao
import com.example.shopapp.model.CartProduct
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val dao: CartDao
) {

    suspend fun getCartProducts(): List<CartProduct> {
        return dao.getAllCartProducts()
    }

    suspend fun getCartProductsFinalPrice():Double {
        return dao.gatCartProductsFinalPrice() ?: 0.0
    }

    suspend fun addCartProduct(cartProduct: CartProduct){
        return dao.addCartProduct(cartProduct)
    }

    suspend fun deleteCartProduct(id:Int){
        return dao.deleteCartProduct(id)
    }

}
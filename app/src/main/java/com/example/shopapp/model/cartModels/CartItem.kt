package com.example.shopapp.model.cartModels


data class CartItem(
    val id:Int,
    val user:Int,
    val date: String,
    val products:CartProduct
)

data class CartProduct(
    val productId:Int,
    val quantity:Int,
)
package com.example.shopapp.model.cartModels

data class CartItem(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)
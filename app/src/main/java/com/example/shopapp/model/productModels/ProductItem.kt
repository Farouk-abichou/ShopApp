package com.example.shopapp.model.productModels




data class ProductItem (
    val id : Int,
    val title: String,
    val price: Float,
    val category : String,
    val image : String,
    val rating : Rating,
)

data class Rating(
    val rate : Float,
    val count : Int
)
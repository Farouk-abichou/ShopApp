package com.example.shopapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CartProduct(
    @PrimaryKey
    val id : Int,
    val title: String,
    val price: Float,
    val category : String,
    val image : String,
    val number : Int,
)
//class InvalidNoteException(message:String):Exception(message)



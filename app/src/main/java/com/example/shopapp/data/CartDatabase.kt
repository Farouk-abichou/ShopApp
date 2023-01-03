package com.example.shopapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shopapp.model.CartProduct


@Database(
    entities =
        [CartProduct::class],
        version=2,
        exportSchema = true
)
abstract class CartDatabase: RoomDatabase(){
    abstract val cartDao: CartDao
    companion object{
        const val  DATABASE_NAME= "cart_db"
    }

}

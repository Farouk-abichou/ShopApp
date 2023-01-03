package com.example.shopapp.data

import androidx.room.*
import com.example.shopapp.model.CartProduct


@Dao
interface CartDao {

    @Query("SELECT * From CartProduct")
    suspend fun getAllCartProducts():List<CartProduct>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCartProduct(product: CartProduct)

    @Query("delete From CartProduct where id =:id")
    suspend fun deleteCartProduct(id:Int)

    @Query("SELECT SUM(price) FROM CartProduct")
    suspend fun gatCartProductsFinalPrice():Double?

}
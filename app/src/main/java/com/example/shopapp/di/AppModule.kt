package com.example.shopapp.di

import android.app.Application
import androidx.room.Room
import com.example.shopapp.data.CartDao
import com.example.shopapp.data.CartDatabase
import com.example.shopapp.network.ProductApi
import com.example.shopapp.repository.ProductRepository
import com.example.shopapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//convert to Gson
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProductRepository(api: ProductApi) = ProductRepository(api)


    @Singleton
    @Provides
    fun provideProductApi():ProductApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    //For Cart Database
    @Provides
    @Singleton
    fun provideCartDatebase(app: Application): CartDatabase {
        return Room.databaseBuilder(
            app,
            CartDatabase::class.java,
            CartDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideNoteDao(db : CartDatabase): CartDao {
        return db.cartDao
    }
}



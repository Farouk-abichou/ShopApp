package com.example.shopapp.di

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
}
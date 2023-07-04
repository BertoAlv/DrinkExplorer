package com.alberto.drinkexplorer.modules

import com.alberto.drinkexplorer.data.network.CocktailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit) : CocktailApi = retrofit.create(CocktailApi::class.java)
}
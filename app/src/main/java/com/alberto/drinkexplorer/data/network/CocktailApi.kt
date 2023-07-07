package com.alberto.drinkexplorer.data.network

import com.alberto.drinkexplorer.data.model.DrinkCategories
import com.alberto.drinkexplorer.data.model.DrinkInfo
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface CocktailApi {

    @GET("list.php?c=list")
    suspend fun getCocktailCategories() : Response<DrinkCategories>

    @GET("filter.php")
    suspend fun getCocktailsThumbnail(@Query("c") category : String): Response<DrinkThumbnail>

    @GET("search.php")
    suspend fun getDrinkDetails(@Query("s")drinkName : String) : Response<DrinkInfo>


}
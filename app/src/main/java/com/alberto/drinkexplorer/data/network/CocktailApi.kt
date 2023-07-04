package com.alberto.drinkexplorer.data.network

import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.Drink
import retrofit2.Response
import retrofit2.http.GET

interface CocktailApi {

    @GET("list.php?c=list")
    suspend fun getCocktailCategories() : Response<Drink>

}
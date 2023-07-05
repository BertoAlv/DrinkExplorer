package com.alberto.drinkexplorer.data.network

import com.alberto.drinkexplorer.data.model.DrinkCategories
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailService @Inject constructor(private val api : CocktailApi) {

    suspend fun getCocktailCategories() : DrinkCategories? {
        return withContext(Dispatchers.IO){
            api.getCocktailCategories().body()
        }
    }

    suspend fun getCocktailsThumbnails() : DrinkThumbnail? {
        return withContext(Dispatchers.IO){
            api.getCocktailsThumbnail().body()
        }
    }

}
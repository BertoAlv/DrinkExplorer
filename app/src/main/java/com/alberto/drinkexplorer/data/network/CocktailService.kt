package com.alberto.drinkexplorer.data.network

import com.alberto.drinkexplorer.data.model.DrinkCategories
import com.alberto.drinkexplorer.data.model.DrinkInfo
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

    suspend fun getCocktailsThumbnails(category : String) : DrinkThumbnail? {
        return withContext(Dispatchers.IO){
            api.getCocktailsThumbnail(category).body()
        }
    }

    suspend fun getDrinkDetails(drinkName : String) : DrinkInfo? {
        return withContext(Dispatchers.IO){
            api.getDrinkDetails(drinkName).body()
        }
    }

}
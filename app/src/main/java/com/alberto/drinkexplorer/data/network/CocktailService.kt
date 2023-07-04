package com.alberto.drinkexplorer.data.network

import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailService @Inject constructor(private val api : CocktailApi) {

    suspend fun getCocktailCategories() : Drink? {
        return withContext(Dispatchers.IO){
            api.getCocktailCategories().body() ?: null
        }
    }

}
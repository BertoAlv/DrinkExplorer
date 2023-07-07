package com.alberto.drinkexplorer.data

import com.alberto.drinkexplorer.data.model.DrinkCategories
import com.alberto.drinkexplorer.data.model.DrinkInfo
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import com.alberto.drinkexplorer.data.network.CocktailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailRepository @Inject constructor(private val service : CocktailService) {

    suspend fun getCocktailCategories() : DrinkCategories? {
        return service.getCocktailCategories()
    }

    suspend fun getCocktailsThumbnails(category : String) : DrinkThumbnail? {
        return service.getCocktailsThumbnails(category)
    }

    suspend fun getDrinkDetails(drinkName : String) : DrinkInfo? {
        return service.getDrinkDetails(drinkName)
    }
}
package com.alberto.drinkexplorer.data

import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.Drink
import com.alberto.drinkexplorer.data.network.CocktailService
import javax.inject.Inject

class CocktailRepository @Inject constructor(private val service : CocktailService) {

    suspend fun getCocktailCategories() : Drink? {
        return service.getCocktailCategories()
    }

}
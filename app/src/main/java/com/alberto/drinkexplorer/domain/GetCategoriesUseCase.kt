package com.alberto.drinkexplorer.domain

import com.alberto.drinkexplorer.data.CocktailRepository
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.Drink
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: CocktailRepository) {

    suspend operator fun invoke() : Drink? = repository.getCocktailCategories()
}
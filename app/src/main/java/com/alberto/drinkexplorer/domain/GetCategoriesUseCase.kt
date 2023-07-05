package com.alberto.drinkexplorer.domain

import com.alberto.drinkexplorer.data.CocktailRepository
import com.alberto.drinkexplorer.data.model.DrinkCategories
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: CocktailRepository) {

    suspend operator fun invoke() : DrinkCategories? = repository.getCocktailCategories()
}
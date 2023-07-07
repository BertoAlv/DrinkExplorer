package com.alberto.drinkexplorer.domain

import com.alberto.drinkexplorer.data.CocktailRepository
import com.alberto.drinkexplorer.data.model.DrinkInfo
import javax.inject.Inject

class GetDrinkDetailsUseCase @Inject constructor(private val repository: CocktailRepository) {

    suspend operator fun invoke(drinkName : String) : DrinkInfo? = repository.getDrinkDetails(drinkName)
}
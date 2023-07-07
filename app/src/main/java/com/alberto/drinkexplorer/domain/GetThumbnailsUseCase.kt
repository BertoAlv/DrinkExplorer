package com.alberto.drinkexplorer.domain

import com.alberto.drinkexplorer.data.CocktailRepository
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import javax.inject.Inject

class GetThumbnailsUseCase @Inject constructor(private val repository: CocktailRepository) {

    suspend operator fun invoke(category : String) : DrinkThumbnail? = repository.getCocktailsThumbnails(category)


}
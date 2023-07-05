package com.alberto.drinkexplorer.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import com.alberto.drinkexplorer.domain.GetCategoriesUseCase
import com.alberto.drinkexplorer.domain.GetThumbnailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(private val getCategories : GetCategoriesUseCase, private val getThumbnail : GetThumbnailsUseCase) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val categoriesLD = MutableLiveData<List<CategoryResponse>>()
    val drinkThumbnails = MutableLiveData<List<DrinkBasic>>()
    val navigateThumbnails = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val categories = getCategories()
            if (categories != null) {
                categoriesLD.postValue(categories.categories)
            }
            isLoading.postValue(false)
        }
    }

    fun onCategoryClicked(){
        navigateThumbnails.postValue(true)
    }

    fun onCreateThumbnails(){
        viewModelScope.launch {
            val thumbnails = getThumbnail()
            if (thumbnails != null) {
                drinkThumbnails.postValue(thumbnails.drinks)
            }
        }
    }

//    fun processImageUrls(response: DrinkThumbnail): DrinkThumbnail {
//        val processedDrinks = response.drinks.map {
//            val newImage = it.image.replace("\\","")
//            it.copy(image = newImage)
//        }
//        return response.copy(drinks = processedDrinks)
//    }

}
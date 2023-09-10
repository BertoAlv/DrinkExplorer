package com.alberto.drinkexplorer.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.Drink
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.domain.GetCategoriesUseCase
import com.alberto.drinkexplorer.domain.GetDrinkDetailsUseCase
import com.alberto.drinkexplorer.domain.GetThumbnailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(private val getCategories : GetCategoriesUseCase,
                                            private val getThumbnail : GetThumbnailsUseCase,
                                            private val getDrinkDetails : GetDrinkDetailsUseCase) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val categoriesLD = MutableLiveData<List<CategoryResponse>>()
    val drinkThumbnails = MutableLiveData<List<DrinkBasic>>()
    val drinkInformation = MutableLiveData<Drink>()

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

    fun onCreateThumbnails(category: String){
        viewModelScope.launch {
            val thumbnails = getThumbnail(category)
            if (thumbnails != null) {
                drinkThumbnails.postValue(thumbnails.drinks)
            }
        }
    }

    fun onGoingDetail(drink : String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = getDrinkDetails(drink)
            if (response != null) {
                drinkInformation.postValue(response.drinks[0])
            }
            isLoading.postValue(false)
        }
    }

}
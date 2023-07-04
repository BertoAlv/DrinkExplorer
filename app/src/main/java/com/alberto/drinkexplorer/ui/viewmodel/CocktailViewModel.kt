package com.alberto.drinkexplorer.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.domain.GetCategoriesUseCase
import com.alberto.drinkexplorer.ui.view.CategoriesAdapter
import com.alberto.drinkexplorer.ui.view.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(private val getCategories : GetCategoriesUseCase) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val categoriesLD = MutableLiveData<List<CategoryResponse>>()

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

}
package com.alberto.drinkexplorer.ui.view.viewholders

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.data.CocktailRepository_Factory
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.databinding.CategoryItemBinding
import com.alberto.drinkexplorer.ui.viewmodel.CocktailViewModel
import javax.inject.Inject

class CategoriesViewHolder (view : View) : RecyclerView.ViewHolder(view) {

    private val binding = CategoryItemBinding.bind(view)

    fun bind(category : CategoryResponse, onClickListener : (CategoryResponse) -> Unit){
        binding.btnCategoryName.text = category.name
        binding.btnCategoryName.setOnClickListener {
            onClickListener(category)
        }
    }
}
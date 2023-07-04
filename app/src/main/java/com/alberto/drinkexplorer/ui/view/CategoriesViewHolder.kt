package com.alberto.drinkexplorer.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.databinding.CategoryItemBinding
import javax.inject.Inject

class CategoriesViewHolder (view : View) : RecyclerView.ViewHolder(view) {

    private val binding = CategoryItemBinding.bind(view)

    fun bind(category : String){
        binding.tvCategoryName.text = category
    }
}
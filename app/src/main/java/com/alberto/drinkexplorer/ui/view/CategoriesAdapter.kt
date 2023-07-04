package com.alberto.drinkexplorer.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.R
import com.alberto.drinkexplorer.data.model.CategoryResponse
import javax.inject.Inject

class CategoriesAdapter @Inject constructor(private var categories : List<CategoryResponse>) : RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoriesViewHolder(layoutInflater.inflate(R.layout.category_item,parent,false))
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        var name = categories[position].name
        holder.bind(name)
    }

    override fun getItemCount(): Int = categories.size

//    fun updateData(newCategories : List<CategoryResponse>){
//        categories = newCategories
//        notifyDataSetChanged()
//    }
}
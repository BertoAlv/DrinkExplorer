package com.alberto.drinkexplorer.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.R
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.ui.view.viewholders.CategoriesViewHolder
import javax.inject.Inject

class CategoriesAdapter(private var categories : List<CategoryResponse>, private val onClickListener : (CategoryResponse) -> Unit) : RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoriesViewHolder(layoutInflater.inflate(R.layout.category_item,parent,false))
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        var name = categories[position]
        holder.bind(name, onClickListener)
    }

    override fun getItemCount(): Int = categories.size

}
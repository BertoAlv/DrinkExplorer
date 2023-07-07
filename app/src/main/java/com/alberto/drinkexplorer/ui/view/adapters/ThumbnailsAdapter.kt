package com.alberto.drinkexplorer.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.R
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.ui.view.viewholders.CategoriesViewHolder
import com.alberto.drinkexplorer.ui.view.viewholders.ThumbnailsViewHolder

class ThumbnailsAdapter(private var thumbnails : List<DrinkBasic>, private val onClickListener : (DrinkBasic) -> Unit) : RecyclerView.Adapter<ThumbnailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ThumbnailsViewHolder(layoutInflater.inflate(R.layout.thumbnail_item,parent,false))
    }

    override fun onBindViewHolder(holder: ThumbnailsViewHolder, position: Int) {
        var drink = thumbnails[position]
        holder.bind(drink,onClickListener)
    }

    override fun getItemCount(): Int = thumbnails.size

    fun updateData(newThumbnails: List<DrinkBasic>) {
        thumbnails = newThumbnails
        notifyDataSetChanged()
    }
}
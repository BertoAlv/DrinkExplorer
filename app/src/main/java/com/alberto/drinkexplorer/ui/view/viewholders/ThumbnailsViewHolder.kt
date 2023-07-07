package com.alberto.drinkexplorer.ui.view.viewholders

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import com.alberto.drinkexplorer.databinding.ThumbnailItemBinding
import com.alberto.drinkexplorer.ui.view.activities.ThumbnailsActivity
import com.squareup.picasso.Picasso

class ThumbnailsViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val binding = ThumbnailItemBinding.bind(view)

    fun bind(drink : DrinkBasic, onClickListener : (DrinkBasic) -> Unit){
        binding.tvDrinkName.text = drink.name
        Picasso.get().load(drink.image).into(binding.ivThumbnail)
        itemView.setOnClickListener {
            onClickListener(drink)
        }
    }
}
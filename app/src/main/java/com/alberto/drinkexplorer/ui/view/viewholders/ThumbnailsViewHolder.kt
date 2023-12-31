package com.alberto.drinkexplorer.ui.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.databinding.ThumbnailItemBinding
import com.squareup.picasso.Picasso

class ThumbnailsViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val binding = ThumbnailItemBinding.bind(view)

    fun bind(drink : DrinkBasic, onClickListener : (DrinkBasic) -> Unit){
        binding.tvDrinkNameThumb.text = drink.name
        Picasso.get().load(drink.image).into(binding.ivThumbnail)
        itemView.setOnClickListener {
            onClickListener(drink)
        }
    }
}
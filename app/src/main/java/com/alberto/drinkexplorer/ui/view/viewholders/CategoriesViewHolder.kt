package com.alberto.drinkexplorer.ui.view.viewholders


import android.media.Image
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.R
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.databinding.CategoryItemBinding
import com.alberto.drinkexplorer.ui.view.activities.MainActivity

class CategoriesViewHolder (view : View) : RecyclerView.ViewHolder(view) {

    private val binding = CategoryItemBinding.bind(view)

    fun bind(category : CategoryResponse, onClickListener : (CategoryResponse) -> Unit){
        binding.btnCategoryName.text = category.name
        when(category.name){
            "Ordinary Drink" -> bind_image(R.drawable.ordinary_drink_icon)
            "Cocktail" -> bind_image(R.drawable.cocktail_icon)
            "Shake" -> bind_image(R.drawable.shake_icon2)
            "Cocoa" -> bind_image(R.drawable.cocoa_icon)
            "Shot" -> bind_image(R.drawable.shot_icon)
            "Coffee / Tea" -> bind_image(R.drawable.coffee_icon)
            "Homemade Liqueur" -> bind_image(R.drawable.baseline_house_24)
            "Punch / Party Drink" -> bind_image(R.drawable.party_drink)
            "Beer" -> bind_image(R.drawable.beer_icon)
            "Soft Drink" -> bind_image(R.drawable.soft_drink)
        }
        binding.btnCategoryName.setOnClickListener {
            onClickListener(category)
        }
    }

    fun bind_image(@DrawableRes image: Int){
        return binding.btnCategoryName.setIconResource(image)
    }
}
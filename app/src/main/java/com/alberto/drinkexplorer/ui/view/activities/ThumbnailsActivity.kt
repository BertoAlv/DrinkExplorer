package com.alberto.drinkexplorer.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.alberto.drinkexplorer.R
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.data.model.DrinkThumbnail
import com.alberto.drinkexplorer.databinding.ActivityThumbnailsBinding
import com.alberto.drinkexplorer.ui.view.adapters.ThumbnailsAdapter
import com.alberto.drinkexplorer.ui.viewmodel.CocktailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThumbnailsActivity : BaseCocktailActivity() {

    private lateinit var binding : ActivityThumbnailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThumbnailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.onCreateThumbnails()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvThumbnails.layoutManager = LinearLayoutManager(this)
        viewModel.drinkThumbnails.observe(this){
            binding.rvThumbnails.adapter = ThumbnailsAdapter(it)
        }

    }

}
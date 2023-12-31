package com.alberto.drinkexplorer.ui.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.alberto.drinkexplorer.data.model.DrinkBasic
import com.alberto.drinkexplorer.databinding.ActivityThumbnailsBinding
import com.alberto.drinkexplorer.ui.view.adapters.ThumbnailsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThumbnailsActivity : BaseCocktailActivity() {

    private lateinit var binding : ActivityThumbnailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThumbnailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var category = intent.extras?.getString("CATEGORY")
        if (category != null) {
            viewModel.onCreateThumbnails(category)
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvThumbnails.layoutManager = GridLayoutManager(this,2)
        viewModel.drinkThumbnails.observe(this){
            binding.rvThumbnails.adapter = ThumbnailsAdapter(it){ drink -> onItemSelected(drink)}
        }
    }

    private fun onItemSelected(drink : DrinkBasic){
        goToDetail(drink.name)
    }

    private fun goToDetail(drink: String) {
        val intent = Intent(this, DrinkInfoActivity::class.java )
        intent.putExtra("DRINK",drink)
        startActivity(intent)
    }
    override fun onBackPressed() {
        finish()
    }



}
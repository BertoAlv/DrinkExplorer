package com.alberto.drinkexplorer.ui.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.databinding.ActivityMainBinding
import com.alberto.drinkexplorer.ui.view.adapters.CategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity () : BaseCocktailActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.onCreate()
        initRecyclerView()

        viewModel.isLoading.observe(this){
            binding.progressBar.isVisible = it
            binding.tvTitle.isVisible = it
        }

    }

    private fun initRecyclerView() {
        binding.rvCategories.layoutManager = LinearLayoutManager(this)
        viewModel.categoriesLD.observe(this){
            binding.rvCategories.adapter = CategoriesAdapter(it){ category -> onItemSelected(category) }
        }
    }

    private fun onItemSelected(category : CategoryResponse){
        navigateToThumbnails(category.name)
    }

    private fun navigateToThumbnails(category: String) {
        val intent = Intent(this, ThumbnailsActivity::class.java)
        intent.putExtra("CATEGORY",category)
        startActivity(intent)
    }

}
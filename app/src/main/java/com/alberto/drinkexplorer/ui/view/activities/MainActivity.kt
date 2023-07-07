package com.alberto.drinkexplorer.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.databinding.ActivityMainBinding
import com.alberto.drinkexplorer.ui.view.adapters.CategoriesAdapter
import com.alberto.drinkexplorer.ui.view.adapters.ThumbnailsAdapter
import com.alberto.drinkexplorer.ui.viewmodel.CocktailViewModel
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
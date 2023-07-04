package com.alberto.drinkexplorer.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.alberto.drinkexplorer.R
import com.alberto.drinkexplorer.data.model.CategoryResponse
import com.alberto.drinkexplorer.databinding.ActivityMainBinding
import com.alberto.drinkexplorer.ui.viewmodel.CocktailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity () : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : CocktailViewModel by viewModels()

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
            binding.rvCategories.adapter = CategoriesAdapter(it)
        }
    }

}
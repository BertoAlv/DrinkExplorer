package com.alberto.drinkexplorer.ui.view.activities

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alberto.drinkexplorer.ui.viewmodel.CocktailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseCocktailActivity : AppCompatActivity() {

    val viewModel: CocktailViewModel by viewModels()

}
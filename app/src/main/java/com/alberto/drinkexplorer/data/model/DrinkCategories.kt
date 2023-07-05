package com.alberto.drinkexplorer.data.model

import com.google.gson.annotations.SerializedName

data class DrinkCategories(
    @SerializedName("drinks")val categories : List<CategoryResponse>
)

package com.alberto.drinkexplorer.data.model

import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("drinks")val categories : List<CategoryResponse>
)

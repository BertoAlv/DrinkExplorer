package com.alberto.drinkexplorer.data.model

import com.google.gson.annotations.SerializedName

data class DrinkInfo(
    @SerializedName("drinks")val drinks: List<Drink>
)

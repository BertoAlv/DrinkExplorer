package com.alberto.drinkexplorer.data.model

import com.google.gson.annotations.SerializedName

data class DrinkBasic(
    @SerializedName("strDrink")val name: String,
    @SerializedName("strDrinkThumb")val image : String
)
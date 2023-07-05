package com.alberto.drinkexplorer.data.model

import com.google.gson.annotations.SerializedName

data class DrinkThumbnail(
    @SerializedName("drinks")val drinks: List<DrinkBasic>
)
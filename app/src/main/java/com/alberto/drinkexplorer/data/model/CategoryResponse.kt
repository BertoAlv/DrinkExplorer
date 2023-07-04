package com.alberto.drinkexplorer.data.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("strCategory")val name : String
)

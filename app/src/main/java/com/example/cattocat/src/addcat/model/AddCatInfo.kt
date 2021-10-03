package com.example.cattocat.src.addcat.model

import com.google.gson.annotations.SerializedName

data class AddCatInfo (
    @SerializedName("cat_name")
    val catName : String
)
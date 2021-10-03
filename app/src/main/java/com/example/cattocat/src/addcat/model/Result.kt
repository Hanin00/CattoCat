package com.example.cattocat.src.addcat.model

import com.google.android.gms.common.server.converter.StringToIntConverter
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("message")
    val message: String
)
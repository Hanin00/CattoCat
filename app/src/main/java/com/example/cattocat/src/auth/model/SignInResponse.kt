package com.example.cattocat.src.auth.model

import com.example.cattocat.src.addcat.model.AddCatInfo
import com.google.gson.annotations.SerializedName

data class  SignInResponse (
    @SerializedName("cusers")
    val signInItem : ArrayList<SignInItem>
)
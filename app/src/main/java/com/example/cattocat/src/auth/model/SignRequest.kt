package com.example.cattocat.src.auth.model

import com.google.gson.annotations.SerializedName

data class SignRequest(
    @SerializedName("email") val email : String,
    @SerializedName("upassword")  val upassword : String,

    )
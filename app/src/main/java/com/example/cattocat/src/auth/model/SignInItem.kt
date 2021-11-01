package com.example.cattocat.src.auth.model

import com.google.gson.annotations.SerializedName

data class SignInItem(
    @SerializedName("uid") val uid: Int,
    @SerializedName("uname") val uname: String,
    @SerializedName("email") val email: String,
    @SerializedName("upassword") val upassword: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("image") val image: String,
    @SerializedName("state") val state: String,
    @SerializedName("city") val city: String,
    @SerializedName("is_active") val is_active: String,
    @SerializedName("is_admin") val is_admin: String,
    @SerializedName("is_superuser") val is_superuser: String,
    @SerializedName("is_staff") val is_staff: String,
)


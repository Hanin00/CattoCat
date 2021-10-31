package com.example.cattocat.src.main.map.model

import com.google.gson.annotations.SerializedName


data class NaverMapResult (
/*
    @SerializedName("roadAddress")
    val roadAddress: String,

    @SerializedName("StringjibunAddress")
    val jibunAddress: String,
*/


    @SerializedName("x") val x: String,
    @SerializedName("y") val y: String
)

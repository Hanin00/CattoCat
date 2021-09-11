package com.example.cattocat.src.main.map.model

import com.google.gson.annotations.SerializedName


class NaverMapResponse (
    @SerializedName("status") val status: String,
    @SerializedName("addresses") val addresses: ArrayList<NaverMapResult>,
)
package com.example.cattocat.src.main.home.model

import com.google.gson.annotations.SerializedName

//todo src 모두 String으로 변경 - url 붙일거니까.
data class HomeInfoItem(
    @SerializedName("info_id") val info_id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("banner_image") val banner_image: String?
)

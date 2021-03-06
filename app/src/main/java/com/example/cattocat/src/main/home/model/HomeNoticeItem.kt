package com.example.cattocat.src.main.home.model

import com.google.gson.annotations.SerializedName

data class HomeNoticeItem(
    @SerializedName("notice_id") val notice_id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("banner_image") val banner_image : String?
    )
package com.example.cattocat.src.main.setting.notice.viewer.info.model

import com.google.gson.annotations.SerializedName

data class InfoSingleItem (
    @SerializedName("info_id") val info_id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content:  String,
    @SerializedName("banner_image") val banner_image: String,
    @SerializedName("created_at") val created_at:  String,

    )
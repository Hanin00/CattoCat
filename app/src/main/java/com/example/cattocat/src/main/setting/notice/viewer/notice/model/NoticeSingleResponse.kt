package com.example.cattocat.src.main.setting.notice.viewer.notice.model

import com.google.gson.annotations.SerializedName

data class NoticeSingleResponse(
    @SerializedName("content") val content:ArrayList<NoticeSingleItem>
)
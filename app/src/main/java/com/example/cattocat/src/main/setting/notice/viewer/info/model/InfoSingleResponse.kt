package com.example.cattocat.src.main.setting.notice.viewer.info.model

import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleItem
import com.google.gson.annotations.SerializedName

data  class InfoSingleResponse(
    @SerializedName("content") val content:ArrayList<InfoSingleItem>
)
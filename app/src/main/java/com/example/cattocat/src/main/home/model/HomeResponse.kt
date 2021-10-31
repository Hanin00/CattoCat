package com.example.cattocat.src.main.home.model

import com.google.gson.annotations.SerializedName

class HomeResponse(
    @SerializedName("bestpost") val bestpost: ArrayList<HomePostItem?>,
    @SerializedName("noticelist") val noticelist: ArrayList<HomeNoticeItem?>,
    @SerializedName("infolist") val infolist: List<HomeInfoItem?>
)
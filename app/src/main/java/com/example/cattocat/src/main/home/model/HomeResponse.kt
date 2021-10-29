package com.example.cattocat.src.main.home.model

import com.google.gson.annotations.SerializedName

class HomeResponse (
    @SerializedName("user_id")
    val Post : HomePostItem,
    val Notice : HomeNoticeItem,
    val AdItem : HomeAdItem
        )
package com.example.cattocat.src.main.setting.myreply.model

import com.google.gson.annotations.SerializedName

class MyReplyResponse (
    @SerializedName("content") val content: ArrayList<MyPostItem>
)
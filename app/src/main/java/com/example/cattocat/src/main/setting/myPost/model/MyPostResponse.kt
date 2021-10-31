package com.example.cattocat.src.main.setting.myreply.model

import com.google.gson.annotations.SerializedName

class MyPostResponse (
    @SerializedName("content") val content: ArrayList<MyPostItem>
)
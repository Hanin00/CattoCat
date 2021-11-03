package com.example.cattocat.src.main.setting.myreply.model

import com.google.gson.annotations.SerializedName

class MyPostItem (
    @SerializedName("reply_id") val reply_id : Int?,
    @SerializedName("user_id") val user_id : Int?,
    @SerializedName("post_id") val post_id : Int?,
    @SerializedName("content") val content : String?,
    @SerializedName("title") val title : String?,
    @SerializedName("image") val image : String?,
    @SerializedName("created_at") val created_at : String?,
)
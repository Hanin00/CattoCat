package com.example.cattocat.src.main.board.posting.model

import com.google.gson.annotations.SerializedName

class PostInfoItem (
    @SerializedName("post_id") val post_id : Int?,
    @SerializedName("user_id") val user_id : Int?,
    @SerializedName("title") val title : String?,
    @SerializedName("content") val content : String?,
    @SerializedName("image") val image : String?,
    @SerializedName("created_at") val created_at : String?,
)
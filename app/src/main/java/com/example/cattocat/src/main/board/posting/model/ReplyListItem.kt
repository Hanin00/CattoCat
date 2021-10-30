package com.example.cattocat.src.main.board.posting.model

import com.google.gson.annotations.SerializedName

class ReplyListItem (
    @SerializedName("reply_id") val reply_id : Int?,
    @SerializedName("user_id") val user_id : Int?,
 //   @SerializedName("user_name") val user_name : Int?,
    @SerializedName("post_id") val post_id : Int?,
    @SerializedName("content") val content : String?,
    @SerializedName("created_at") val created_at : String?,
)
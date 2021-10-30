package com.example.cattocat.src.main.board.posting.model

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("post_id") val post_id: String,
    @SerializedName("post") val post:  List<PostInfoItem>,
    @SerializedName("userinfo") val userinfo:  List<UserInfoItem>,
    @SerializedName("replylist") val replylist: ArrayList<ReplyListItem>,
)

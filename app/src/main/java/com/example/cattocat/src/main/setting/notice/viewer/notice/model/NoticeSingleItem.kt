package com.example.cattocat.src.main.setting.notice.viewer.notice.model

import com.example.cattocat.src.main.board.posting.model.PostInfoItem
import com.example.cattocat.src.main.board.posting.model.ReplyListItem
import com.example.cattocat.src.main.board.posting.model.UserInfoItem
import com.google.gson.annotations.SerializedName

data class NoticeSingleItem(
    @SerializedName("notice_id") val notice_id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content:  String,
    @SerializedName("banner_image") val banner_image: String,
    @SerializedName("created_at") val created_at:  String,
)
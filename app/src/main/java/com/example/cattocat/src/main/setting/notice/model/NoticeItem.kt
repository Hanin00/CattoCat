package com.example.cattocat.src.main.setting.notice.model

import com.example.cattocat.src.main.board.posting.model.PostInfoItem
import com.google.gson.annotations.SerializedName

data class NoticeItem (
    val noticeIdx :Int,
    val noticeTitle : String,
    val banner_image : String,
)
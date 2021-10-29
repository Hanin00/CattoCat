package com.example.cattocat.src.main.board.model

import com.google.gson.annotations.SerializedName

data class BoardItem(
    @SerializedName("post_id") val post_id: Int?,
    @SerializedName("user_id") val user_id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("is_active") val is_active: String?,
    @SerializedName("created_at") val created_at: String?
)


//사진들 안들어왔음
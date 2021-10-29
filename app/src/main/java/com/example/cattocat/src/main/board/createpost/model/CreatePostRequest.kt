package com.example.cattocat.src.main.board.createpost.model

import com.google.gson.annotations.SerializedName

data class CreatePostRequest(
    @SerializedName("user_id")
    val user_id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("is_activte")
    val is_activte: String?,

    )
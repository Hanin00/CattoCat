package com.example.cattocat.src.main.board.model

import com.google.gson.annotations.SerializedName

data class BoardResponse(
    @SerializedName("postlist")
    val postlist: ArrayList<BoardItem>
)
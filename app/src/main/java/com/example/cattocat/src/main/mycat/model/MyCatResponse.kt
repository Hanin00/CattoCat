package com.example.cattocat.src.main.mycat.model

import com.example.cattocat.src.main.board.model.BoardItem
import com.google.gson.annotations.SerializedName


data class MyCatResponse(
    @SerializedName("content")
    val content: ArrayList<MyCatItem>
)
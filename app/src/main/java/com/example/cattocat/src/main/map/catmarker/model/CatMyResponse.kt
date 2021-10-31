package com.example.cattocat.src.main.map.catmarker.model

import com.example.cattocat.src.main.board.posting.model.ReplyListItem
import com.google.gson.annotations.SerializedName

data class CatMyResponse (

    @SerializedName("content") val content: ArrayList<CatMarkerItem>
        )
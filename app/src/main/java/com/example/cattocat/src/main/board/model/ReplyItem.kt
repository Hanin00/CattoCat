package com.example.cattocat.src.main.board.model


data class ReplyItem(
    val replyIdx: Int, val userIdx: Int,
    val userName: String, val userImg: Int, val reply: String,
    val date : String
)

//todo itemIdx 없어도 될 듯?
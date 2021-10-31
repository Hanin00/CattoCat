package com.example.cattocat.src.main.board.posting

import com.example.cattocat.src.main.board.posting.model.PostResponse
import com.example.cattocat.src.main.board.posting.model.ReplyListItem


interface PostView {

    fun onGetPostInfoSuccess(result: PostResponse)
    fun onGetPostInfoFailure(message:String)

    fun onPostReplySuccess(result: ReplyListItem)
    fun onPostReplyFailure(message:String)
}
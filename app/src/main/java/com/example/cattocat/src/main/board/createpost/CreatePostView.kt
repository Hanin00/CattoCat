package com.example.cattocat.src.main.board.createpost

import com.example.cattocat.src.main.board.createpost.model.CreatePostRequest
import com.example.cattocat.src.main.board.model.BoardResponse

interface CreatePostView {
    fun onPostPostingSuccess(result: CreatePostRequest)
    fun onPostPostingFailure(message:String)

}
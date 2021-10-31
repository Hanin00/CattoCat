package com.example.cattocat.src.main.setting.myreply

import com.example.cattocat.src.main.setting.myreply.model.MyPostResponse

interface MyPostView {
    fun onGetMyReplySuccess(result: MyPostResponse)
    fun onGetMyReplyFailure(message:String)
}
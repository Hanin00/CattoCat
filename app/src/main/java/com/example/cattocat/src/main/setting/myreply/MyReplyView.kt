package com.example.cattocat.src.main.setting.myreply

import com.example.cattocat.src.main.setting.myreply.model.MyPostResponse
import com.example.cattocat.src.main.setting.myreply.model.MyReplyResponse

interface MyReplyView {
    fun onGetMyReplySuccess(result: MyReplyResponse)
    fun onGetMyReplyFailure(message:String)
}
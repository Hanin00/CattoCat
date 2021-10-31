package com.example.cattocat.src.main.setting.notice.viewer.notice

import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleResponse

interface NoticeSingleView {
    fun onGetNoticeSingleSuccess(result: NoticeSingleResponse)
    fun onGetNoticeSingleFailure(message:String)

}
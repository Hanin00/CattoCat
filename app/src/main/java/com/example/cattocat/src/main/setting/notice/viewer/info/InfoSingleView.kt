package com.example.cattocat.src.main.setting.notice.viewer.info

import com.example.cattocat.src.main.setting.notice.viewer.info.model.InfoSingleResponse

interface InfoSingleView {
    fun onGetInfoSingleSuccess(result: InfoSingleResponse)
    fun onGetInfoSingleFailure(message:String)
}
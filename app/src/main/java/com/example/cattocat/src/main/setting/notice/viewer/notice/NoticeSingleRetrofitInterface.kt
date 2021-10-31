package com.example.cattocat.src.main.setting.notice.viewer.notice

import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticeSingleRetrofitInterface {
    @GET("cats/noticecnt/")
    fun getNotice(@Query("notice_id") notice_id: Int,): Call<NoticeSingleResponse>
}
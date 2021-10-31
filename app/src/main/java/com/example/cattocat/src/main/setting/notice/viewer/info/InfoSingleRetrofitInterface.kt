package com.example.cattocat.src.main.setting.notice.viewer.info

import com.example.cattocat.src.main.setting.notice.viewer.info.model.InfoSingleResponse
import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InfoSingleRetrofitInterface {
    @GET("cats/infocnt/")
    fun getInfo(@Query("info_id") info_id: Int,): Call<InfoSingleResponse>
}
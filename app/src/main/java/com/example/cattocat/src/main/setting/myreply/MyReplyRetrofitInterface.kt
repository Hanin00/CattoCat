package com.example.cattocat.src.main.setting.myreply

import com.example.cattocat.src.main.setting.myreply.model.MyPostResponse
import com.example.cattocat.src.main.setting.myreply.model.MyReplyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyReplyRetrofitInterface {
    @GET("cats/reply")
    fun getMyReply(
        @Query("user_id") user_id: Int
    ): Call<MyReplyResponse>
}
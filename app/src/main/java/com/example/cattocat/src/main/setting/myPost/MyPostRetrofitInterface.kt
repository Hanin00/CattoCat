package com.example.cattocat.src.main.setting.myreply

import com.example.cattocat.src.main.setting.myreply.model.MyPostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyPostRetrofitInterface {
    @GET("cats/mypost")
    fun getMyReply(
        @Query("user_id") user_id: Int
    ): Call<MyPostResponse>
}
package com.example.cattocat.src.main.mycat

import com.example.cattocat.src.main.board.model.BoardResponse
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MyCatRetrofitInterface {
    @GET("cats/mycat/")
    fun getMyCat(@Query("user_id") user_id: Int): Call<MyCatResponse>
}
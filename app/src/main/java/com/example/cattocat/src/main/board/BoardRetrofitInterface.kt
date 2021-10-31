package com.example.cattocat.src.main.board

import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.main.board.model.BoardResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BoardRetrofitInterface {
    @GET("cats/post/")
    fun getBoard(): Call<BoardResponse>
}
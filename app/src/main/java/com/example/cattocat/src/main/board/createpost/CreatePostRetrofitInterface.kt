package com.example.cattocat.src.main.board.createpost

import com.example.cattocat.src.main.board.createpost.model.CreatePostRequest
import com.example.cattocat.src.main.board.model.BoardResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CreatePostRetrofitInterface {
    @POST("cats/posting/")
    fun postPosting(@Body createPostRequest : CreatePostRequest): Call<CreatePostRequest>
}
package com.example.cattocat.src.main.board.posting

import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.main.board.model.BoardResponse
import com.example.cattocat.src.main.board.model.ReplyItem
import com.example.cattocat.src.main.board.posting.model.PostResponse
import com.example.cattocat.src.main.board.posting.model.ReplyListItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface PostRetrofitInterface {
    @GET("cats/postsingle?")
    fun getPostInfo(
        @Query("post_id") post_id: Int,
        @Query("user_id") user_id: Int
    ): Call<PostResponse>

    @POST("cats/postsingle/")
    fun postReply(@Body reply: ReplyListItem): Call<Unit>

}
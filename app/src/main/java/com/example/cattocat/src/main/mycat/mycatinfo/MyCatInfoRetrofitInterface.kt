package com.example.cattocat.src.main.mycat.mycatinfo

import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface MyCatInfoRetrofitInterface {
    @PUT("cats/catdetail/{cat_id}/")
    fun modifyCatInfo(
        @Path("cat_id") user_id: Int,
        @Body mycatInfo: MyCatItem
    ): Call<MyCatItem>
}
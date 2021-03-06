package com.example.cattocat.src.main.map.catmarker

import com.example.cattocat.src.main.map.catmarker.model.CatMarkerItem
import com.example.cattocat.src.main.map.catmarker.model.CatMyResponse
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatMarkerRetrofitInterface {
    @GET("cats/totalcat/")
    fun getTotalCat(): Call<ArrayList<CatMarkerItem>>

    @GET("cats/mycat/")
    fun getMyCat(@Query("user_id") user_id: Int): Call<CatMyResponse>
}
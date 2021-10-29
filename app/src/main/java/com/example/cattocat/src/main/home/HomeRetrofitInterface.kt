package com.example.cattocat.src.main.home

import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.main.home.model.HomeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface HomeRetrofitInterface {
    @POST("cat/home/")
    fun getHome(): Call<HomeResponse>

}


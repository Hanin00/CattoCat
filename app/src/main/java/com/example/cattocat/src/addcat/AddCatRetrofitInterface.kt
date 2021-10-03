package com.example.cattocat.src.addcat

import com.example.cattocat.src.addcat.model.Result
import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST



interface AddCatRetrofitInterface {
    @FormUrlEncoded
    @POST("cats/totalcat/")
    fun postAddCat(@Body addCatInfo : AddCatInfo): Call<Result>
}


package com.example.cattocat.src.addcat

import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST



interface AddCatRetrofitInterface {
    @POST("cats/totalcat/")
    fun postAddCat(@Body addCatResponse: AddCatInfo): Call<AddCatInfo>

}


package com.example.cattocat.src.auth

import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.auth.model.SignInResponse
import com.example.cattocat.src.auth.model.SignRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface SignInRetrofitInterface {
    @POST("accounts/")
    fun postAddCat(
       @Body request:SignRequest): Call<SignInResponse>

}


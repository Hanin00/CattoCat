package com.example.cattocat.src.auth

import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.auth.model.SignInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface SignInRetrofitInterface {
    @POST("accounts/")
    fun postAddCat(
        @Query("email") email: String,
        @Query("upassword") upassword: String): Call<SignInResponse>

}


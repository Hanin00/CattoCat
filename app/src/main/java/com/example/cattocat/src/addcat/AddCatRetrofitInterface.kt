package com.example.cattocat.src.addcat

import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST



interface AddCatRetrofitInterface {
    @FormUrlEncoded
    @POST("cats/totalcat/")
<<<<<<< HEAD
    fun postAddCat(@Body addCatInfo: ArrayList<AddCatInfo>): Call<AddCatInfo>


=======
    fun postAddCat(@Body addCatInfo: AddCatInfo): Call<ArrayList<AddCatInfo>>
>>>>>>> b713d9c (등록 api 연결 시도)
}


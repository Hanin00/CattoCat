package com.example.cattocat.src.main.map

import com.example.cattocat.src.main.map.model.NaverMapResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverMapRetrofitInterface {

    //Header를 okhttp의 interceptor 이용하여 처리하였음
    /*    @Headers(
        "X-NCP-APIGW-API-KEY-ID: ${R.string.naver_maps_client_id} ",
        "X-NCP-APIGW-API-KEY: ${R.string.naver_maps_client_secret}"
    )*/


    @GET("map-geocode/v2/geocode")
    fun getNaverMapAddress(
        @Query("query") query: String
    ): Call<NaverMapResponse>
}


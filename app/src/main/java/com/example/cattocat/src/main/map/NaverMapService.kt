package com.example.cattocat.src.main.map

import com.example.cattocat.R
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.map.model.NaverMapResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NaverMapService(val view: NaverMapView){

    fun getAddress(location: String) {
  //  fun getSelectLocationLatLon(location: String) {
        val mapRetrofitInterface =
            MyApplication.naverRetrofit.create(NaverMapRetrofitInterface::class.java)
        mapRetrofitInterface.getNaverMapAddress(location).enqueue(object : Callback<NaverMapResponse> {
                override fun onResponse(
                    call: Call<NaverMapResponse>,
                    response: Response<NaverMapResponse>
                ) {
                    if (response.body()?.status == "OK") {
                        view.onGetNaverMapSuccess(response.body()!!.addresses)
                    } else {
                        //오류
                        view.onGetNaverMapFailed(R.string.naver_maps_message_error_default)
                    }
                }

                override fun onFailure(call: Call<NaverMapResponse>, t: Throwable) {
                    view.onGetNaverMapFailed(R.string.naver_maps_message_error_default)
                }

            })

    }

}
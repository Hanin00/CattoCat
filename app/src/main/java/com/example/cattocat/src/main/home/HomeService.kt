package com.example.cattocat.src.main.home

import android.content.Context
import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.home.model.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeView){
    fun tryGetHome(){
        val homeRetrofitInterface = MyApplication.mRetrofit.create(HomeRetrofitInterface::class.java)

        homeRetrofitInterface.getHome().enqueue(object:
            Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {

                if(response!=null){
                    view.onGetHomeSuccess(response?.body() as HomeResponse)
                    Log.d("Test","msg : ${response.code()}")
                    Log.d("Test","msg : ${response.message()}")
                }else{
                    Log.d("Test","값 없음")
                }

                if(response.code()==400){
                    Log.d("Test","--")
                }
                if(response.code()==404){
                    Log.d("Test","찾을 수 없음")
                }

            }
            override fun onFailure(call: Call<HomeResponse?>, t: Throwable) {
                view.onGetHomeFailure(t.message ?: "게시글 송신 관련 통신 오류")
            }

        })

    }
}
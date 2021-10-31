package com.example.cattocat.src.main.mycat

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import com.example.cattocat.src.main.mycat.mycatinfo.MyCatInfoFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyCatService(val view: MyCatView, val user_id:Int) {
    fun tryGetMyCat(){
        val myCatRetrofitInterface = MyApplication.mRetrofit.create(MyCatRetrofitInterface::class.java)

        myCatRetrofitInterface.getMyCat(user_id).enqueue(object:
            Callback<MyCatResponse> {
            override fun onResponse(call: Call<MyCatResponse>, response: Response<MyCatResponse>) {
                view.onGetCatSuccess(response.body() as MyCatResponse)

                if(response!=null){
                    Log.d("Test","NULL 아님")
                    Log.d("Test","body ${response.body()}")
                }else{
                    Log.d("Test","값 없음")
                }

                if(response.code()==400){
                    Log.d("Test","--")
                }

            }
            override fun onFailure(call: Call<MyCatResponse>, t: Throwable) {
                view.onGetCatFailure(t.message ?: "내 고양이 송신 관련 통신 오류")
            }

        })

    }

}
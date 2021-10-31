package com.example.cattocat.src.main.setting.notice.viewer.info

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.setting.notice.viewer.info.model.InfoSingleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoSingleService(val view: InfoSingleView, val info_id: Int) {
    fun tryGetNoticeSingle() {
        val infoSingleRetrofitInterface =
            MyApplication.mRetrofit.create(InfoSingleRetrofitInterface::class.java)

        infoSingleRetrofitInterface.getInfo(info_id).enqueue(object :
            Callback<InfoSingleResponse> {
            override fun onResponse(
                call: Call<InfoSingleResponse>,
                response: Response<InfoSingleResponse>
            ) {
                view.onGetInfoSingleSuccess(response.body() as InfoSingleResponse)
                //exceptions 필요 -400
                Log.d("Test", "Result : ${response.isSuccessful}")
                Log.d("Test", "Result : ${response.body()}")

                if (response.code() == 400) {
                    Log.d("Test", "--")
                }
            }

            override fun onFailure(call: Call<InfoSingleResponse>, t: Throwable) {
                view.onGetInfoSingleFailure(t.message ?: "단일 게시글 송신 관련 통신 오류")
            }
        })
    }
}
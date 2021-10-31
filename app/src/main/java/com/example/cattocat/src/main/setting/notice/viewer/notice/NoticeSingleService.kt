package com.example.cattocat.src.main.setting.notice.viewer.notice

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NoticeSingleService(val view: NoticeSingleView, val notice_id: Int) {
    fun tryGetNoticeSingle() {
        val noticeSingleRetrofitInterface =
            MyApplication.mRetrofit.create(NoticeSingleRetrofitInterface::class.java)

        noticeSingleRetrofitInterface.getNotice(notice_id).enqueue(object :
            Callback<NoticeSingleResponse> {
            override fun onResponse(
                call: Call<NoticeSingleResponse>,
                response: Response<NoticeSingleResponse>
            ) {
                view.onGetNoticeSingleSuccess(response.body() as NoticeSingleResponse)

                //exceptions 필요 -400
                Log.d("Test", "Result : ${response.isSuccessful}")
                Log.d("Test", "Result : ${response.body()}")

                if (response.code() == 400) {
                    Log.d("Test", "--")
                }

            }

            override fun onFailure(call: Call<NoticeSingleResponse>, t: Throwable) {
                view.onGetNoticeSingleFailure(t.message ?: "단일 게시글 송신 관련 통신 오류")

            }

        })

    }
}
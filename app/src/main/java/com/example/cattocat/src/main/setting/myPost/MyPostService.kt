package com.example.cattocat.src.main.setting.myreply

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.setting.myreply.model.MyPostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPostService(val view: MyPostView, val reply_id:Int) {
    fun tryGetPostSingle(){
        val myReplyRetrofitInterface = MyApplication.mRetrofit.create(MyPostRetrofitInterface::class.java)

        myReplyRetrofitInterface.getMyReply(reply_id).enqueue(object:
            Callback<MyPostResponse> {
            override fun onResponse(call: Call<MyPostResponse>, response: Response<MyPostResponse>) {
                view.onGetMyReplySuccess(response.body() as MyPostResponse)

                //exceptions 필요 -400
                Log.d("Test", "Result : ${response.isSuccessful}")
                Log.d("Test", "Result : ${response.body()}")

                if(response.code()==400){
                    Log.d("Test","--")
                }

            }
            override fun onFailure(call: Call<MyPostResponse>, t: Throwable) {
                view.onGetMyReplyFailure(t.message ?: "단일 게시글 송신 관련 통신 오류")

            }

        })

    }
}
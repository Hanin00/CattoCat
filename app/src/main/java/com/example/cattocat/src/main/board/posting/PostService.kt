package com.example.cattocat.src.main.board.posting

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.board.posting.model.PostResponse
import com.example.cattocat.src.main.board.posting.model.ReplyListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostService(val view: PostView, val post_id:Int, val user_id:Int) {
    fun tryGetPostSingle(post_id: Int, user_id: Int){
        val postRetrofitInterface = MyApplication.mRetrofit.create(PostRetrofitInterface::class.java)

        postRetrofitInterface.getPostInfo(post_id, user_id).enqueue(object:
            Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                view.onGetPostInfoSuccess(response.body() as PostResponse)

                //exceptions 필요 -400
                Log.d("Test", "Result : ${response.isSuccessful}")
                Log.d("Test", "Result : ${response.body()}")

                if(response.code()==400){
                    Log.d("Test","--")
                }

            }
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                view.onGetPostInfoFailure(t.message ?: "단일 게시글 송신 관련 통신 오류")

            }

        })

    }

    fun tryPostReply(reply: ReplyListItem){
        val postRetrofitInterface = MyApplication.mRetrofit.create(PostRetrofitInterface::class.java)
        postRetrofitInterface.postReply(reply).enqueue(object:Callback<Unit>{
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                view.onPostReplyFailure(t.message ?: "댓글 등록 통신 오류")
            }

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {

                Log.d("Test","댓글 입력됨")
                //exceptions 필요 -400

                if(response.code()==400){
                    Log.d("Test"," 내용을 입력해주세요.")
                }
            }

        })

    }
}

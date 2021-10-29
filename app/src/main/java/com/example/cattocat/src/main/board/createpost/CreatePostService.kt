package com.example.cattocat.src.main.board.createpost

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.board.BoardRetrofitInterface
import com.example.cattocat.src.main.board.BoardView
import com.example.cattocat.src.main.board.createpost.model.CreatePostRequest
import com.example.cattocat.src.main.board.model.BoardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreatePostService(val view: CreatePostView, val request : CreatePostRequest) {
    fun tryPostCreatePost(){
        val createPostRetrofitInterface = MyApplication.mRetrofit.create(CreatePostRetrofitInterface::class.java)

        createPostRetrofitInterface.postPosting(request).enqueue(object:Callback<CreatePostRequest> {
            override fun onResponse(call: Call<CreatePostRequest?>, response: Response<CreatePostRequest?>) {
                view.onPostPostingSuccess(response.body() as CreatePostRequest)

                //exceptions 필요 -400

                if(response!=null){

                }else{
                    Log.d("Test","값 없음")
                }

                if(response.code()==400){
                    Log.d("Test","--")
                }

            }
            override fun onFailure(call: Call<CreatePostRequest>, t: Throwable) {
                view.onPostPostingFailure(t.message ?: "게시글 송신 관련 통신 오류")
            }

        })

    }

}
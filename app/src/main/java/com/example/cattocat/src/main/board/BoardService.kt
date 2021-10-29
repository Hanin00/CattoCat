package com.example.cattocat.src.main.board

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.main.board.model.BoardItem
import com.example.cattocat.src.main.board.model.BoardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoardService(val view: BoardView) {
   // fun tryGetBoard(boardResponse: BoardResponse){
    fun tryGetBoard(){
        val boardRetrofitInterface = MyApplication.mRetrofit.create(BoardRetrofitInterface::class.java)

       boardRetrofitInterface.getBoard().enqueue(object:
            Callback<BoardResponse> {
            override fun onResponse(call: Call<BoardResponse?>, response: Response<BoardResponse?>) {
                view.onGetBoardSuccess(response.body() as BoardResponse)

                //exceptions 필요 -400
                
                if(response!=null){
                    
                }else{
                    Log.d("Test","값 없음")
                }

                if(response.code()==400){
                    Log.d("Test","--")
                }

            }
            override fun onFailure(call: Call<BoardResponse>, t: Throwable) {
                view.onGetBoardFailure(t.message ?: "게시글 송신 관련 통신 오류")
            }

        })

    }

}
package com.example.cattocat.src.main.map.catmarker

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.map.catmarker.model.CatMarkerItem
import com.example.cattocat.src.main.map.catmarker.model.CatMyResponse
import com.example.cattocat.src.main.mycat.MyCatActivity
import com.example.cattocat.src.main.mycat.MyCatRetrofitInterface
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatMarkerService(val view: CatMarkerView, val user_id : Int) {
    fun tryTotalCat(){
        val catMarkerRetrofitInterface = MyApplication.mRetrofit.create(CatMarkerRetrofitInterface::class.java)

        catMarkerRetrofitInterface.getTotalCat().enqueue(object:Callback<ArrayList<CatMarkerItem>> {
            override fun onResponse(call: Call<ArrayList<CatMarkerItem>>, response: Response<ArrayList<CatMarkerItem>>) {
                view.onGetTotalCatSuccess(response.body() as ArrayList<CatMarkerItem>)

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
            override fun onFailure(call: Call<ArrayList<CatMarkerItem>>, t: Throwable) {
                view.onGetTotalFailure(t.message ?: "전체 고양이 송신 관련 통신 오류")
            }

        })

    }

    fun tryMyCat(){
        val catMarkerRetrofitInterface = MyApplication.mRetrofit.create(CatMarkerRetrofitInterface::class.java)

        catMarkerRetrofitInterface.getMyCat(user_id).enqueue(object:Callback<CatMyResponse> {
            override fun onResponse(call: Call<CatMyResponse>, response: Response<CatMyResponse>) {
                view.onGetMyCatSuccess(response.body() as CatMyResponse)

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
            override fun onFailure(call: Call<CatMyResponse>, t: Throwable) {
                view.onGetTotalFailure(t.message ?: "내 고양이 송신 관련 통신 오류")
            }

        })

    }
}
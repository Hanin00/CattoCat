package com.example.cattocat.src.main.mycat.mycatinfo

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.main.mycat.model.MyCatItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyCatInfoService(val view: MyCatInfoFragment, val cat_id:Int, val body: MyCatItem) {
    fun tryPutMyCatInfo(){
        val myCatInfoRetrofitInterface = MyApplication.mRetrofit.create(MyCatInfoRetrofitInterface::class.java)

        myCatInfoRetrofitInterface.modifyCatInfo(cat_id,body).enqueue(object:
            Callback<MyCatItem> {
            override fun onResponse(call: Call<MyCatItem>, response: Response<MyCatItem>) {
             //   view.onPutCatInfoSuccess(response.body() as MyCatItem)

                if(response!=null){
                    Log.d("Test","body ${response.body()}")
                    Log.d("Test","response.isSuccessful ${response.isSuccessful()}")
                    Log.d("Test","response.code ${response.code()}")
                }else{
                    Log.d("Test","값 없음")
                }

                if(response.code()==400){
                    Log.d("Test","--")
                }

            }
            override fun onFailure(call: Call<MyCatItem>, t: Throwable) {
              //  view.onPutCatInfoFailure(t.message ?: "고양이 정보 수정 관련 통신 오류")
            }

        })

    }

}
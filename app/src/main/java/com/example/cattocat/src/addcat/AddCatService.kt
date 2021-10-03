package com.example.cattocat.src.addcat

import android.widget.Toast
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCatService (val view:AddCatView){

    fun tryPostAddCat(page: Int,mCallback: AddCatActivity) {
        val addCatRetrofitInterface = MyApplication.mRetrofit.create(AddCatRetrofitInterface::class.java)
        addCatRetrofitInterface.postAddCat().enqueue(object : Callback<AddCatInfo> {
            override fun onResponse( // 통신에 성공한 경우
                call: Call<AddCatInfo>,
                response: Response<AddCatInfo>
            ) {
                if(response.isSuccessful()){ // 응답을 잘 받은 경우
                    mCallback.loadComplete(response.body()!!.data)
                } else {
                    // 통신은 성공했지만 응답에 문제가 있는 경우
                    view.onPostAddCatFailure("다시 시도해주세요")
                }
            }

            override fun onFailure(call: Call<AddCatInfo>, t: Throwable) {
                // 통신에 실패한 경우
               // view.onPostAddCatFailure("다시 시도해주세요")

                Toast.makeText(this, "다시 시도해주세요",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
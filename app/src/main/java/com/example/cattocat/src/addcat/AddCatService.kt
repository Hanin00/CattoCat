package com.example.cattocat.src.addcat


import com.example.cattocat.config.MyApplication.Companion.mRetrofit

import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddCatService(val view:AddCatView) {

    fun tryPostAddCat(addCatInfo: AddCatInfo){
        val addCatInfoRetrofitInterface = mRetrofit.create(AddCatRetrofitInterface::class.java)
        addCatInfoRetrofitInterface.postAddCat(addCatInfo).enqueue(object:
            Callback<AddCatInfo>{
            override fun onResponse(call: Call<AddCatInfo>, response: Response<AddCatInfo>) {
                view.onPostAddCatSuccess(response.body() as AddCatInfo)
            }

            override fun onFailure(call: Call<AddCatInfo>, t: Throwable) {
                view.onPostAddCatFailure(t.message ?: "고양이 등록 통신 오류")
            }

        })

    }
}

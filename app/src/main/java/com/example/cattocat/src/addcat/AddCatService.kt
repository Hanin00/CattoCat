package com.example.cattocat.src.addcat

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

<<<<<<< HEAD
class AddCatService (val view:AddCatView){

    fun tryPostAddCat(page: Int,mCallback: AddCatActivity) {
        val addCatRetrofitInterface = MyApplication.mRetrofit.create(AddCatRetrofitInterface::class.java)

    }
}
=======
class AddCatService(val view: AddCatView)

fun tryPostAddCat(page: Int, mCallback: AddCatActivity) {
    val addCatRetrofitInterface =
        MyApplication.mRetrofit.create(AddCatRetrofitInterface::class.java)

    //Body에 담을 데이터 생성
    val addCatInfo = ArrayList<AddCatInfo>()

    addCatRetrofitInterface.postAddCat(addCatInfo)?.enqueue(object : Callback<AddCatInfo> {
        override fun onFailure(call: Call<AddCatInfo>, t: Throwable) {
            Log.d(
                "AddCatApi::", "Failed API call with call: " + call +
                        " + exception: " + t
            )
        }

        override fun onResponse(call: Call<AddCatInfo>, response: Response<AddCatInfo>) {
            Log.d("Response:: ", response.body().toString())
            val addCatInfo = response.body()!!

            Log.d("Test:: ", addCatInfo.toString())
        }
    })
}


>>>>>>> c6fe8bc (no message)

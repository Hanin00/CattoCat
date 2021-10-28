package com.example.cattocat.src.addcat

<<<<<<< HEAD
import android.util.Log
import com.example.cattocat.config.MyApplication
=======
import com.example.cattocat.config.MyApplication.Companion.mRetrofit
>>>>>>> b713d9c (등록 api 연결 시도)
import com.example.cattocat.src.addcat.model.AddCatInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

<<<<<<< HEAD
<<<<<<< HEAD
class AddCatService (val view:AddCatView){
=======
>>>>>>> b713d9c (등록 api 연결 시도)

class AddCatService(val view:AddCatView) {

    fun tryPostAddCat(addCatInfo: AddCatInfo){
        val addCatInfoRetrofitInterface = mRetrofit.create(AddCatRetrofitInterface::class.java)
        addCatInfoRetrofitInterface.postAddCat(addCatInfo).enqueue(object:
            Callback<ArrayList<AddCatInfo>>{
            override fun onResponse(call: Call<ArrayList<AddCatInfo>>, response: Response<ArrayList<AddCatInfo>>) {
                view.onPostAddCatSuccess(response.body() as AddCatInfo)
            }

            override fun onFailure(call: Call<ArrayList<AddCatInfo>>, t: Throwable) {
                view.onPostAddCatFailure(t.message ?: "병원 검색 관련 통신 오류")
            }

        })

    }
}
<<<<<<< HEAD
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
=======
>>>>>>> b713d9c (등록 api 연결 시도)

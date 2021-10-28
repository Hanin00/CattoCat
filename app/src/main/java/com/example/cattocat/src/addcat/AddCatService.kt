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

    }
}
package com.example.cattocat.src.auth

import android.util.Log
import com.example.cattocat.config.MyApplication
import com.example.cattocat.src.auth.model.SignInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInService(val view: SignInView, val email: String, val password: String) {
    fun trySignIn() {
        val signInRetrofitInterface =
            MyApplication.mRetrofit.create(SignInRetrofitInterface::class.java)
        signInRetrofitInterface.postAddCat(email, password ).enqueue(object :
            Callback<SignInResponse> {
            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {

                Log.d("Test", "msg : ${response.message()}")
                Log.d("Test", "msg : ${response.body()}")
                if(response.body() != null){
                    view.onSignInSuccess(response.body() as SignInResponse)
                }

                //exceptions 필요 -400

                if (response.code() == 400) {
                    Log.d("Test", " 내용을 입력해주세요.")
                }

            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                view.oonSignInFailure(t.message ?:  "로그인 통신 오류")
            }

        })

    }
}

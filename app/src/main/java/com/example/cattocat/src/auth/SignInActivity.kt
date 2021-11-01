package com.example.cattocat.src.auth

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivitySigninBinding
import com.example.cattocat.src.auth.model.SignInResponse

class SignInActivity:AppCompatActivity(),SignInView {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.signinEdEmail.text.toString()
        val password = binding.signinEdPw.text.toString()

        binding.signinBtnSign.setOnClickListener {
            //todo login 연결
        SignInService(this,email, password).trySignIn()

        }
    }

    override fun onSignInSuccess(result: SignInResponse) {  
        //todo sharedPreferences로 companion 저장
        Log.d("test","body : ${result.signInItem}")
        finish()
    }

    override fun oonSignInFailure(message: String) {
        Log.e("Test", "oonSignInFailure: $message")
 
    }
}
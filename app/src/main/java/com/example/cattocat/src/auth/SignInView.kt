package com.example.cattocat.src.auth

import com.example.cattocat.src.auth.model.SignInResponse

interface SignInView {
    fun onSignInSuccess(result: SignInResponse)
    fun oonSignInFailure(message:String)

}
package com.example.cattocat.src.main.mycat

import com.example.cattocat.src.main.mycat.model.MyCatResponse

interface MyCatView {
    fun onGetCatSuccess(result: MyCatResponse)
    fun onGetCatFailure(message:String)

}
package com.example.cattocat.src.addcat

import com.example.cattocat.src.addcat.model.AddCatInfo

interface AddCatView {
    fun onPostAddCatSuccess(result : AddCatInfo)
    fun onPostAddCatFailure(message:String)

}
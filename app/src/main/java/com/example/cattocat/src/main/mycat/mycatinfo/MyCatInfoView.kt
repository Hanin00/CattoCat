package com.example.cattocat.src.main.mycat.mycatinfo

import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.model.MyCatResponse

interface MyCatInfoView {
    fun onPutCatInfoSuccess(result: MyCatItem)
    fun onPutCatInfoFailure(message:String)
}
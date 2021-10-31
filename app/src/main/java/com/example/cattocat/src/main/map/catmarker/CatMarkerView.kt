package com.example.cattocat.src.main.map.catmarker

import com.example.cattocat.src.main.map.catmarker.model.CatMarkerItem
import com.example.cattocat.src.main.mycat.model.MyCatResponse


interface CatMarkerView {
    fun onGetTotalCatSuccess(result: ArrayList<CatMarkerItem>)
    fun onGetTotalFailure(message:String)

}
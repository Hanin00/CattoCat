package com.example.cattocat.src.main.map

import com.example.cattocat.src.main.map.model.NaverMapResult

interface NaverMapView {
    fun onGetNaverMapSuccess(result : ArrayList<NaverMapResult>)
    fun onGetNaverMapFailed(message: Int)
}
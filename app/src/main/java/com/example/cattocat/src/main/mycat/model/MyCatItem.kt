package com.example.cattocat.src.main.mycat.model

data class MyCatItem (
    val catIdx : Int, val catName : String, val catImg : Int,
    val catLocate : String,
    val catColor : String, val catPrefer : String, val catEye : String,
    val catDid : Int, val catMomIdx : Int, val catMomName : String,

)

//catDid : 중성화 여부
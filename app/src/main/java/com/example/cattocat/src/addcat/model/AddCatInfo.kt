package com.example.cattocat.src.addcat.model

import com.google.gson.annotations.SerializedName

data class AddCatInfo (
<<<<<<< HEAD
    @SerializedName("cat_name")    val catName : String,
    @SerializedName("cat_name")    val cat_eye : String,
    @SerializedName("cat_name")    val cat_hair : Int,
    @SerializedName("cat_name")    val cat_socks : Int,
    @SerializedName("cat_name")    val cat_locate : String,
    @SerializedName("cat_name")    val cat_mom : Int,
    @SerializedName("cat_name")    val cat_tnr : Int,
    @SerializedName("cat_name")    val cat_prefer : String,
    @SerializedName("cat_name")    val cat_special : String,
    @SerializedName("cat_name")    val cat_prof_img : String,
    @SerializedName("cat_name")    val cat_image : String,
)

/*
data class AddCatInfo (
    @SerializedName("cat_name")
    val catName : String,
    val cat_eye : String,
    val cat_hair : Int,
    val cat_socks : Int,
    val cat_locate : String,
    val cat_mom : Int,
    val cat_tnr : Int,
    val cat_prefer : List<String>,
    val cat_special : List<String>,
    val cat_prof_img : String,
    val cat_image : String,
)*/
=======
    @SerializedName("user_id")
    val user_id : Int,
    @SerializedName("cat_name")
    val cat_name : String,
    @SerializedName("cat_eye")
    val cat_eye : String,
    @SerializedName("cat_hair")
    val cat_hair : String,
    @SerializedName("cat_socks")
    val cat_socks : String,
    @SerializedName("cat_locate")
    val cat_locate : String,
    @SerializedName("cat_mom")
    val cat_mom : Int,
    @SerializedName("cat_tnr")
    val cat_tnr : Int,
    @SerializedName("cat_prefer")
    val cat_prefer : String,
    @SerializedName("cat_special")
    val cat_special : String,
    @SerializedName("cat_prof_img")
    val cat_prof_img : String,
    @SerializedName("cat_image")
    val cat_image : String,
    @SerializedName("cat_xlocation")
    val cat_xlocation : String,
    @SerializedName("cat_ylocation")
    val cat_ylocation : String,
)
>>>>>>> b713d9c (등록 api 연결 시도)

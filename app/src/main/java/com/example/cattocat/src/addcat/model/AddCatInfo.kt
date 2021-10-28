package com.example.cattocat.src.addcat.model

import com.google.gson.annotations.SerializedName

data class AddCatInfo (
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

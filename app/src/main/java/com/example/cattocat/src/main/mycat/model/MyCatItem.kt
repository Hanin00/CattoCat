package com.example.cattocat.src.main.mycat.model

import com.google.gson.annotations.SerializedName

data class MyCatItem (
    @SerializedName("cat_id") val cat_id : Int,
    @SerializedName("user_id") val user_id : Int,
    @SerializedName("cat_name") val cat_name : String?,
    @SerializedName("cat_eye") val cat_eye : String?,
    @SerializedName("cat_hair") val cat_hair : String?,
    @SerializedName("cat_socks") val cat_socks : String?,
    @SerializedName("cat_locate") val cat_locate : String?,
    @SerializedName("cat_mom") val cat_mom : Int?,
    @SerializedName("cat_tnr") val cat_tnr : Int?,
    @SerializedName("cat_prefer") val cat_prefer : String?,
    @SerializedName("cat_special") val cat_special : String?,
    @SerializedName("cat_prof_img")     val cat_prof_img : String?,
    @SerializedName("cat_image") val cat_image : String?,
    @SerializedName("cat_xlocation") val cat_xlocation : String?,
    @SerializedName("cat_ylocation") val cat_ylocation : String?,
    @SerializedName("is_active") val is_active : Int?,

    )

//catDid : 중성화 여부
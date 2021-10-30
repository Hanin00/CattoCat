package com.example.cattocat.src.main.board.posting.model

import com.google.gson.annotations.SerializedName

class UserInfoItem (
@SerializedName("uid") val uid : Int?,
@SerializedName("uname") val uname : String?,
@SerializedName("email") val email : String?,
@SerializedName("image") val image : String?,
@SerializedName("city") val city : String?,
)
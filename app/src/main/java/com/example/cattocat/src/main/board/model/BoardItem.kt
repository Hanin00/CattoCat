package com.example.cattocat.src.main.board.model

data class BoardItem(val userIdx: Int,val contentIdx : Int,
                     val userName: String,val boardLocate: String,
                     val userLocate: String, val title: String,
                     val date: String, val content: String, val dummyImg: Int, val userImg: Int,  )


//사진들 안들어왔음
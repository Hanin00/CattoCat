package com.example.cattocat.src.main.board

import androidx.annotation.BoolRes
import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.main.board.model.BoardResponse


interface BoardView {
    fun onGetBoardSuccess(result: BoardResponse)
    fun onGetBoardFailure(message:String)

}
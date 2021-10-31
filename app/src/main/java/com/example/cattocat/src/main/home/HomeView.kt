package com.example.cattocat.src.main.home

import com.example.cattocat.src.main.board.model.BoardResponse
import com.example.cattocat.src.main.home.model.HomeResponse

interface HomeView {

    fun onGetHomeSuccess(result: HomeResponse)
    fun onGetHomeFailure(message:String)

}
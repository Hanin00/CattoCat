package com.example.cattocat.config

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseActivity<B : ViewBinding>(private val inflate : (LayoutInflater)-> B) : AppCompatActivity()
{
    protected lateinit var binding : B
    private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
    }
}

/*

object RetrofitBuilder{
    var api : API
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("haeunlee.pythonanywhere.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }
}

*/
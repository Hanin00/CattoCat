package com.example.cattocat.src.addcat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityAddCatBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AddCatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}


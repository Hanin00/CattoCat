package com.example.cattocat.src.main.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityMainBinding
import com.example.cattocat.databinding.ActivityMapBinding
import com.example.cattocat.databinding.ActivitySplashBinding

//map
class MapActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
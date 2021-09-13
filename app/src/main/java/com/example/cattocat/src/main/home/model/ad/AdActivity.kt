package com.example.cattocat.src.main.home.model.ad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityAdBinding

class AdActivity : AppCompatActivity(){
    private lateinit var binding : ActivityAdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }

}
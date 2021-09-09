package com.example.cattocat.src.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.config.BaseActivity
import com.example.cattocat.databinding.ActivityMainBinding


//class MainActivity : AppCompatActivity() {
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )


    }
}
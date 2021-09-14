package com.example.cattocat.src.main.setting.notice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityNoticeBinding

class No : AppCompatActivity() {
    private lateinit var binding : ActivityNoticeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
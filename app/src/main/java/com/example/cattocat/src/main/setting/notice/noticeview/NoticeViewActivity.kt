package com.example.cattocat.src.main.setting.notice.noticeview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityNoticeViewBinding


class NoticeViewActivity : AppCompatActivity(){
    private lateinit var binding : ActivityNoticeViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
package com.example.cattocat.src.main.setting.notice.noticeview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityNoticeViewBinding


class NoticeViewActivity : AppCompatActivity(){
    private lateinit var binding : ActivityNoticeViewBinding
    private var noticeIdx : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(intent.hasExtra("noticeIdx")){
            noticeIdx = intent.getStringExtra("noticeIdx")!!.toInt()
            Log.d("Test","if문 안 noticeIdx - $noticeIdx")
            
        }
        Log.d("Test","if문 밖 noticeIdx - $noticeIdx")

    }

}
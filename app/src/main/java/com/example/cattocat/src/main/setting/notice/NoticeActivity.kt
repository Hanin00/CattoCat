package com.example.cattocat.src.main.setting.notice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.databinding.ActivityNoticeBinding
import com.example.cattocat.src.main.setting.notice.adapter.NoticeRecyAdapter
import com.example.cattocat.src.main.setting.notice.model.NoticeItem
import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleItem

class NoticeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNoticeBinding
    private lateinit var noticeRecyAdpater : NoticeRecyAdapter
    private var noticeItemList = ArrayList<NoticeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(intent.hasExtra("isUse")){
            binding.noticeTvTitle.setText("사용안내")
        }else if(intent.hasExtra("isUser")){
            binding.noticeTvTitle.setText("회원설정")
        }else if(intent.hasExtra("isUserInfo")){
            binding.noticeTvTitle.setText("사용자 정보 변경")
        }


        binding.noticeIvBack.setOnClickListener {
            finish()
        }
    }

    //todo recycler Adapter
    private fun noticeRecyAdapter(noticeItem : ArrayList<NoticeItem>){
        noticeRecyAdpater = NoticeRecyAdapter(noticeItem, this)
        binding.noticeRecy.apply{
            adapter = noticeRecyAdpater
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            noticeRecyAdpater.notifyDataSetChanged()
        }
    }
}



package com.example.cattocat.src.main.setting.notice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.databinding.ActivityNoticeBinding
import com.example.cattocat.src.main.board.model.BoardItem
import com.example.cattocat.src.main.setting.notice.adapter.NoticeRecyAdapter
import com.example.cattocat.src.main.setting.notice.model.NoticeItem

class NoticeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNoticeBinding
    private lateinit var noticeRecyAdpater : NoticeRecyAdapter
    private var noticeItemList = ArrayList<NoticeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.noticeIvBack.setOnClickListener {
            finish()
        }


        noticeItemList.add(NoticeItem(1,"디자인 업데이트 v1.1.2","https",))
        noticeItemList.add(NoticeItem(2,"디자인 업데이트 v1.1.3","https",))
        noticeItemList.add(NoticeItem(3,"디자인 업데이트 v1.1.4","https",))
        noticeItemList.add(NoticeItem(5,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(6,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(7,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(8,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(9,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(1,"디자인 업데이트 v1.1.2","https",))
        noticeItemList.add(NoticeItem(2,"디자인 업데이트 v1.1.3","https",))
        noticeItemList.add(NoticeItem(3,"디자인 업데이트 v1.1.4","https",))
        noticeItemList.add(NoticeItem(5,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(6,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(7,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(8,"디자인 업데이트 v1.1.5","https",))
        noticeItemList.add(NoticeItem(9,"디자인 업데이트 v1.1.5","https",))


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


